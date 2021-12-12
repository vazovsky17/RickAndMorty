package app.vazovsky.rick_and_morty.data.repository

import app.vazovsky.rick_and_morty.data.model.responses.CharacterResponse
import app.vazovsky.rick_and_morty.data.model.responses.EpisodeResponse
import app.vazovsky.rick_and_morty.data.model.responses.LocationResponse
import app.vazovsky.rick_and_morty.data.remote.ApiService
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCountLocations(): Int = apiService.getCountLocations()
    suspend fun getLocationById(id: Int): LocationResponse = apiService.getLocationById(id)
}