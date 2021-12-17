package app.vazovsky.rick_and_morty.presentation.character.filter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.vazovsky.rick_and_morty.data.model.State
import app.vazovsky.rick_and_morty.data.repository.CharacterRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterFilterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {
    private val _stateStatusLiveData = MutableLiveData<State<List<String>>>()
    val stateStatusLiveData: LiveData<State<List<String>>> = _stateStatusLiveData

    fun loadStatusList() {
        viewModelScope.launch {
            _stateStatusLiveData.postValue(State.Loading())
            try {
                val list = characterRepository.getStatusList()
                _stateStatusLiveData.postValue(State.Data(list))

            } catch (e: Exception) {
                _stateStatusLiveData.postValue(State.Error(e))
            }
        }
    }

    private val _stateSpeciesLiveData = MutableLiveData<State<List<String>>>()
    val stateSpeciesLiveData: LiveData<State<List<String>>> = _stateSpeciesLiveData

    fun loadSpeciesList() {
        viewModelScope.launch {
            _stateSpeciesLiveData.postValue(State.Loading())
            try {
                val list = characterRepository.getSpeciesList()
                _stateSpeciesLiveData.postValue(State.Data(list))

            } catch (e: Exception) {
                _stateSpeciesLiveData.postValue(State.Error(e))
            }
        }
    }

    private val _stateTypeLiveData = MutableLiveData<State<List<String>>>()
    val stateTypeLiveData: LiveData<State<List<String>>> = _stateTypeLiveData

    fun loadTypeList() {
        viewModelScope.launch {
            _stateTypeLiveData.postValue(State.Loading())
            try {
                val list = characterRepository.getTypeList()
                _stateTypeLiveData.postValue(State.Data(list))

            } catch (e: Exception) {
                _stateTypeLiveData.postValue(State.Error(e))
            }
        }
    }

    private val _stateGenderLiveData = MutableLiveData<State<List<String>>>()
    val stateGenderLiveData: LiveData<State<List<String>>> = _stateGenderLiveData

    fun loadGenderList() {
        viewModelScope.launch {
            _stateGenderLiveData.postValue(State.Loading())
            try {
                val list = characterRepository.getGenderList()
                _stateGenderLiveData.postValue(State.Data(list))

            } catch (e: Exception) {
                _stateGenderLiveData.postValue(State.Error(e))
            }
        }
    }

    private val _stateLocationLiveData = MutableLiveData<State<List<String>>>()
    val stateLocationLiveData: LiveData<State<List<String>>> = _stateLocationLiveData

    fun loadLocationList() {
        viewModelScope.launch {
            _stateLocationLiveData.postValue(State.Loading())
            try {
                val list = characterRepository.getLocationList().map { it.name }
                _stateLocationLiveData.postValue(State.Data(list.sorted()))
            } catch (e: Exception) {
                _stateLocationLiveData.postValue(State.Error(e))
            }
        }
    }
}