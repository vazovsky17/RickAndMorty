package app.vazovsky.rick_and_morty.presentation.character.filter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.vazovsky.rick_and_morty.data.db.entity.Location
import app.vazovsky.rick_and_morty.data.model.filter.Filter
import app.vazovsky.rick_and_morty.data.model.State
import app.vazovsky.rick_and_morty.data.model.filter.FilterLocation
import app.vazovsky.rick_and_morty.data.repository.CharacterRepository
import app.vazovsky.rick_and_morty.data.repository.EpisodeRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterFilterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val episodeRepository: EpisodeRepository
) : ViewModel() {
    private val _stateStatusLiveData = MutableLiveData<State<List<Filter>>>()
    val stateStatusLiveData: LiveData<State<List<Filter>>> = _stateStatusLiveData

    private fun String.toFilter() = Filter(this)
    private fun Location.toFilter() = FilterLocation(this)

    fun loadStatusList() {
        viewModelScope.launch {
            _stateStatusLiveData.postValue(State.Loading())
            try {
                val list = characterRepository.getStatusList().map { it.toFilter() }
                _stateStatusLiveData.postValue(State.Data(list))
            } catch (e: Exception) {
                _stateStatusLiveData.postValue(State.Error(e))
            }
        }
    }

    private val _stateSpeciesLiveData = MutableLiveData<State<List<Filter>>>()
    val stateSpeciesLiveData: LiveData<State<List<Filter>>> = _stateSpeciesLiveData

    fun loadSpeciesList() {
        viewModelScope.launch {
            _stateSpeciesLiveData.postValue(State.Loading())
            try {
                val list = characterRepository.getSpeciesList().map { it.toFilter() }
                _stateSpeciesLiveData.postValue(State.Data(list))

            } catch (e: Exception) {
                _stateSpeciesLiveData.postValue(State.Error(e))
            }
        }
    }

    private val _stateTypeLiveData = MutableLiveData<State<List<Filter>>>()
    val stateTypeLiveData: LiveData<State<List<Filter>>> = _stateTypeLiveData

    fun loadTypeList() {
        viewModelScope.launch {
            _stateTypeLiveData.postValue(State.Loading())
            try {
                val list = characterRepository.getTypeList().map { it.toFilter() }
                _stateTypeLiveData.postValue(State.Data(list))

            } catch (e: Exception) {
                _stateTypeLiveData.postValue(State.Error(e))
            }
        }
    }

    private val _stateGenderLiveData = MutableLiveData<State<List<Filter>>>()
    val stateGenderLiveData: LiveData<State<List<Filter>>> = _stateGenderLiveData

    fun loadGenderList() {
        viewModelScope.launch {
            _stateGenderLiveData.postValue(State.Loading())
            try {
                val list = characterRepository.getGenderList().map { it.toFilter() }
                _stateGenderLiveData.postValue(State.Data(list))

            } catch (e: Exception) {
                _stateGenderLiveData.postValue(State.Error(e))
            }
        }
    }

    private val _stateLocationLiveData = MutableLiveData<State<List<FilterLocation>>>()
    val stateLocationLiveData: LiveData<State<List<FilterLocation>>> = _stateLocationLiveData

    fun loadLocationList() {
        viewModelScope.launch {
            _stateLocationLiveData.postValue(State.Loading())
            try {
                val list = characterRepository.getLocationList().sortedBy { it.name }.map { it.toFilter() }
                _stateLocationLiveData.postValue(State.Data(list))
            } catch (e: Exception) {
                _stateLocationLiveData.postValue(State.Error(e))
            }
        }
    }
}