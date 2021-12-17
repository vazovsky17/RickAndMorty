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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationListViewModel @Inject constructor(
    private val repository: LocationRepository
) : ViewModel() {

    private val _stateLiveData = MutableLiveData<State<List<LocationEntity>>>()
    val stateLiveData: LiveData<State<List<LocationEntity>>> = _stateLiveData

    private var searchJob: Job? = null

    fun loadLocations() {
        viewModelScope.launch {
            _stateLiveData.postValue(State.Loading())
            try {
                repository.getAllLocations().collect { list ->
                    _stateLiveData.postValue(State.Data(list))
                }
            } catch (e: Exception) {
                _stateLiveData.postValue(State.Error(e))
            }
        }
    }
    fun searchLocations(search: String) {
        searchJob?.cancel()
        searchJob = CoroutineScope(Dispatchers.IO).launch {
            delay(500)
            _stateLiveData.postValue(State.Loading())
            try {
                val list = repository.searchLocations(search)
                _stateLiveData.postValue(State.Data(list))
            } catch (e: Exception) {
                _stateLiveData.postValue(State.Error(e))
            }
        }
    }
}