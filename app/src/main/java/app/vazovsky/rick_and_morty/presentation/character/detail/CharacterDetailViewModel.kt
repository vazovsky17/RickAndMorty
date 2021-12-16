package app.vazovsky.rick_and_morty.presentation.character.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.vazovsky.rick_and_morty.data.db.entity.EpisodeEntity
import app.vazovsky.rick_and_morty.data.db.entity.LocationEntity
import app.vazovsky.rick_and_morty.data.model.State
import app.vazovsky.rick_and_morty.data.repository.EpisodeRepository
import app.vazovsky.rick_and_morty.data.repository.LocationRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterDetailViewModel @Inject constructor(
    private val episodeRepository: EpisodeRepository,
    private val locationRepository: LocationRepository
) : ViewModel() {
    private val _stateEpisodeLiveData = MutableLiveData<State<List<EpisodeEntity>>>()
    val stateEpisodeLiveData: LiveData<State<List<EpisodeEntity>>> = _stateEpisodeLiveData

    private val _stateLocationLiveData = MutableLiveData<State<MutableList<LocationEntity?>>>()
    val stateLocationLiveData: LiveData<State<MutableList<LocationEntity?>>> = _stateLocationLiveData

    fun loadEpisodes(ids: List<Int>) {
        viewModelScope.launch {
            _stateEpisodeLiveData.postValue(State.Loading())
            try {
                episodeRepository.getEpisodesByIds(ids).collect { list ->
                    _stateEpisodeLiveData.postValue(State.Data(list))
                }
            } catch (e: Exception) {
                _stateEpisodeLiveData.postValue(State.Error(e))
            }
        }
    }

    companion object {
        const val ORIGIN = "origin"
        const val LOCATION = "location"
    }

    fun loadLocation(ids: Map<String, Int>) {
        viewModelScope.launch {
            val list = mutableListOf<LocationEntity?>(null, null)
            _stateLocationLiveData.postValue(State.Loading())
            try {
                //Ищем Origin
                ids[ORIGIN]?.let { locationRepository.getLocationsByIds(it) }?.let { origin ->
                    if (origin.isNotEmpty()) {
                        list[0] = origin[0]
                    }
                }
                //Ищем Location
                ids[LOCATION]?.let { locationRepository.getLocationsByIds(it) }?.let { location ->
                    if (location.isNotEmpty()) {
                        list[1] = location[0]
                    }
                }
                _stateLocationLiveData.postValue(State.Data(list))
            } catch (e: Exception) {
                _stateLocationLiveData.postValue(State.Error(e))
            }
        }
    }
}