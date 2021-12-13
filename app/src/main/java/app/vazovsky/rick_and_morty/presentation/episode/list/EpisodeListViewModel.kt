package app.vazovsky.rick_and_morty.presentation.episode.list

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.data.db.entity.EpisodeEntity
import app.vazovsky.rick_and_morty.data.db.entity.parseToEpisodeEntity
import app.vazovsky.rick_and_morty.data.model.State
import app.vazovsky.rick_and_morty.data.repository.EpisodeRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodeListViewModel @Inject constructor(
    private val repository: EpisodeRepository
) : ViewModel() {

    private val _stateLiveData = MutableLiveData<State<List<EpisodeEntity>>>()
    val stateLiveData: LiveData<State<List<EpisodeEntity>>> = _stateLiveData

    private val _episodesLiveData = MutableLiveData<List<EpisodeEntity>>()
    val episodesLiveData: LiveData<List<EpisodeEntity>> = _episodesLiveData

    fun loadEpisodes() {
        viewModelScope.launch {
            _stateLiveData.postValue(State.Loading())
            try {
                repository.getAllEpisodes().collect { list ->
                    _stateLiveData.postValue(State.Data(list))
                }
            } catch (e: Exception) {
                _stateLiveData.postValue(State.Error(e))
            }
        }
    }


    fun subscribeToEpisodes(context: Context) {
        viewModelScope.launch {
            repository.getAllEpisodes().collect {
                _episodesLiveData.postValue(it)
            }
        }
    }
}