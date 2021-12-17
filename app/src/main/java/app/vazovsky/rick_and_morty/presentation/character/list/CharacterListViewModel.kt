package app.vazovsky.rick_and_morty.presentation.character.list

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.data.model.State
import app.vazovsky.rick_and_morty.data.repository.CharacterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterListViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _stateLiveData = MutableLiveData<State<List<CharacterEntity>>>()
    val stateLiveData: LiveData<State<List<CharacterEntity>>> = _stateLiveData

    private var searchJob: Job? = null

    fun loadCharacters() {
        viewModelScope.launch {
            _stateLiveData.postValue(State.Loading())
            try {
                repository.getAllCharacters().collect { list ->
                    _stateLiveData.postValue(State.Data(list))
                }
            } catch (e: Exception) {
                _stateLiveData.postValue(State.Error(e))
            }
        }
    }

    fun searchCharacters(search: String) {
        searchJob?.cancel()
        searchJob = CoroutineScope(Dispatchers.IO).launch {
            delay(2000)
            _stateLiveData.postValue(State.Loading())
            try {
                repository.searchCharacters(search).collect { list ->
                    _stateLiveData.postValue(State.Data(list))
                }
            } catch (e: Exception) {
                _stateLiveData.postValue(State.Error(e))
            }
        }
    }
}