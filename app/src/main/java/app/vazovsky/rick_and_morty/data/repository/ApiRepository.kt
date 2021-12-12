package app.vazovsky.rick_and_morty.data.repository

import android.location.Location
import app.vazovsky.rick_and_morty.data.model.CharacterResponse
import app.vazovsky.rick_and_morty.data.model.EpisodeResponse
import app.vazovsky.rick_and_morty.data.model.LocationResponse
import app.vazovsky.rick_and_morty.data.remote.ApiService
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCountCharacters(): Int {
        return apiService.getCountCharacters()
    }

    suspend fun getCountLocations(): Int {
        return apiService.getCountLocations()
    }

    suspend fun getCountEpisodes(): Int {
        return apiService.getCountEpisodes()
    }

    suspend fun getCharacterById(id: Int): CharacterResponse {
        return apiService.getCharacterById(id)
    }

    suspend fun getLocationById(id: Int): LocationResponse {
        return apiService.getLocationById(id)
    }

    suspend fun getEpisodeById(id: Int): EpisodeResponse {
        return apiService.getEpisodeById(id)
    }
}