package app.vazovsky.rick_and_morty.data.repository

import app.vazovsky.rick_and_morty.data.model.responses.Location
import app.vazovsky.rick_and_morty.data.remote.ApiService
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCountLocations(): Int = apiService.getCountLocations()
    suspend fun getLocationById(id: Int): Location = apiService.getLocationById(id)
}