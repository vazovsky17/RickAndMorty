package app.vazovsky.rick_and_morty.presentation.episode.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.data.model.State
import app.vazovsky.rick_and_morty.data.repository.CharacterRepository
import app.vazovsky.rick_and_morty.data.repository.EpisodeRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodeDetailViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {
    private val _stateCharacterLiveData = MutableLiveData<State<List<CharacterEntity>>>()
    val stateCharacterLiveData: LiveData<State<List<CharacterEntity>>> = _stateCharacterLiveData

    fun loadCharacters(ids: List<Int>) {
        viewModelScope.launch {
            _stateCharacterLiveData.postValue(State.Loading())
            try {
                characterRepository.getCharactersByIds(ids).collect { list ->
                    _stateCharacterLiveData.postValue(State.Data(list))
                }
            } catch (e: Exception) {
                _stateCharacterLiveData.postValue(State.Error(e))
            }
        }
    }
}