package app.vazovsky.rick_and_morty.presentation.character.list

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.data.db.entity.parseToCharacterEntity
import app.vazovsky.rick_and_morty.data.model.State
import app.vazovsky.rick_and_morty.data.repository.CharacterRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterListViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {
    companion object {
        const val MAX_CHARACTER_ID = 826
    }

    private val _stateLiveData = MutableLiveData<State<List<CharacterEntity>>>()
    val stateLiveData: LiveData<State<List<CharacterEntity>>> = _stateLiveData

    private val _charactersLiveData = MutableLiveData<List<CharacterEntity>>()
    val charactersLiveData: LiveData<List<CharacterEntity>> = _charactersLiveData

    fun loadCharacters() {
        viewModelScope.launch {
            _stateLiveData.postValue(State.Loading())
            try {
                repository.getAllCharacters().collect { list ->
                    if (list.size < MAX_CHARACTER_ID) {
                        for (id in (list.size + 1)..MAX_CHARACTER_ID) {
                            val character = repository.getCharacterById(id).parseToCharacterEntity()
                            repository.insertCharacter(character)
                        }
                    }
                    _stateLiveData.postValue(State.Data(list))

                }

            } catch (e: Exception) {
                _stateLiveData.postValue(State.Error(e))
            }
        }
    }

    fun subscribeToCharacters(context: Context) {
        viewModelScope.launch {
            repository.getAllCharacters().collect {
                _charactersLiveData.postValue(it)
            }
        }
    }
}