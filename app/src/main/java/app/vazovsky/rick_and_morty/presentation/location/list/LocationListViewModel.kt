package app.vazovsky.rick_and_morty.presentation.location.list

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import app.vazovsky.rick_and_morty.data.db.entity.LocationEntity
import app.vazovsky.rick_and_morty.data.db.entity.parseToLocationEntity
import app.vazovsky.rick_and_morty.data.model.State
import app.vazovsky.rick_and_morty.data.repository.LocationRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationListViewModel @Inject constructor(
    private val repository: LocationRepository
) : ViewModel() {
    companion object {
        const val MAX_LOCATION_ID = 126
    }

    private val _stateLiveData = MutableLiveData<State<List<LocationEntity>>>()
    val stateLiveData: LiveData<State<List<LocationEntity>>> = _stateLiveData

    private val _locationsLiveData = MutableLiveData<List<LocationEntity>>()
    val locationsLiveData: LiveData<List<LocationEntity>> = _locationsLiveData

    fun loadLocations() {
        viewModelScope.launch {
            _stateLiveData.postValue(State.Loading())
            try {
                repository.getAllLocations().collect { list ->
                    if (list.size < MAX_LOCATION_ID) {
                        for (id in (list.size + 1)..MAX_LOCATION_ID) {
                            val location = repository.getLocationById(id).parseToLocationEntity()
                            repository.insertLocation(location)
                        }
                    }
                    _stateLiveData.postValue(State.Data(list))
                }
            } catch (e: Exception) {
                _stateLiveData.postValue(State.Error(e))
            }
        }
    }

    fun subscribeToLocations(context: Context) {
        viewModelScope.launch {
            repository.getAllLocations().collect {
                _locationsLiveData.postValue(it)
            }
        }
    }
}