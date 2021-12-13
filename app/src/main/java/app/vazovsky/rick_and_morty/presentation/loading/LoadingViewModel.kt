package app.vazovsky.rick_and_morty.presentation.loading

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.vazovsky.rick_and_morty.data.db.entity.parseToCharacterEntity
import app.vazovsky.rick_and_morty.data.db.entity.parseToEpisodeEntity
import app.vazovsky.rick_and_morty.data.db.entity.parseToLocationEntity
import app.vazovsky.rick_and_morty.data.model.StateDownloadProgress
import app.vazovsky.rick_and_morty.data.repository.CharacterRepository
import app.vazovsky.rick_and_morty.data.repository.EpisodeRepository
import app.vazovsky.rick_and_morty.data.repository.LocationRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoadingViewModel @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val episodeRepository: EpisodeRepository,
    private val locationRepository: LocationRepository
) : ViewModel() {
    companion object {
        const val MAX_CHARACTER_ID = 826
        const val MAX_EPISODE_ID = 51
        const val MAX_LOCATION_ID = 126
    }

    private val _characterProgressLiveData = MutableLiveData<StateDownloadProgress>()
    val characterProgressLiveData: LiveData<StateDownloadProgress> = _characterProgressLiveData

    private val _episodeProgressLiveData = MutableLiveData<StateDownloadProgress>()
    val episodeProgressLiveData: LiveData<StateDownloadProgress> = _episodeProgressLiveData

    private val _locationProgressLiveData = MutableLiveData<StateDownloadProgress>()
    val locationProgressLiveData: LiveData<StateDownloadProgress> = _locationProgressLiveData

    fun loadData() {
        viewModelScope.launch {
            try {
                loadCharacters()
                loadEpisodes()
                loadLocations()
            } catch (e: Exception) {

            }
        }
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            try {
                characterRepository.getAllCharacters().collect { characters ->
                    if (characters.size < MAX_CHARACTER_ID) {
                        for (id in (characters.size + 1)..MAX_CHARACTER_ID) {
                            val character = characterRepository.getCharacterById(id).parseToCharacterEntity()
                            val percent = id * 100 / MAX_CHARACTER_ID
                            _characterProgressLiveData.postValue(StateDownloadProgress.Progress(percent))
                            characterRepository.insertCharacter(character)
                        }
                    } else {
                        _characterProgressLiveData.postValue(StateDownloadProgress.Progress(100))
                    }
                }
            } catch (e: Exception) {
                _characterProgressLiveData.postValue(StateDownloadProgress.Error("Не удалось загрузить Characters"))
            }
        }
    }

    private fun loadEpisodes() {
        viewModelScope.launch {
            try {
                episodeRepository.getAllEpisodes().collect { episodes ->
                    if (episodes.size < MAX_EPISODE_ID) {
                        for (id in (episodes.size + 1)..MAX_EPISODE_ID) {
                            val episode = episodeRepository.getEpisodeById(id).parseToEpisodeEntity()
                            val percent = id * 100 / MAX_EPISODE_ID
                            _episodeProgressLiveData.postValue(StateDownloadProgress.Progress(percent))
                            episodeRepository.insertEpisode(episode)
                        }
                    } else {
                        _episodeProgressLiveData.postValue(StateDownloadProgress.Progress(100))
                    }
                }
            } catch (e: Exception) {
                _episodeProgressLiveData.postValue(StateDownloadProgress.Error("Не удалось загрузить Episodes"))
            }
        }
    }

    private fun loadLocations() {
        viewModelScope.launch {
            try {
                locationRepository.getAllLocations().collect { locations ->
                    if (locations.size < MAX_LOCATION_ID) {
                        for (id in (locations.size + 1)..MAX_LOCATION_ID) {
                            val location = locationRepository.getLocationById(id).parseToLocationEntity()
                            val percent = id * 100 / MAX_LOCATION_ID
                            _locationProgressLiveData.postValue(StateDownloadProgress.Progress(percent))
                            locationRepository.insertLocation(location)
                        }
                    } else {
                        _locationProgressLiveData.postValue(StateDownloadProgress.Progress(100))
                    }
                }
            } catch (e: Exception) {
                _locationProgressLiveData.postValue(StateDownloadProgress.Error("Не удалось загрузить Locations"))
            }
        }
    }
}