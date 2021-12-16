package app.vazovsky.rick_and_morty.data.repository

import app.vazovsky.rick_and_morty.data.db.AppDatabase
import app.vazovsky.rick_and_morty.data.db.entity.LocationEntity
import app.vazovsky.rick_and_morty.data.model.responses.LocationFullResponse
import app.vazovsky.rick_and_morty.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) {
    suspend fun getLocationById(id: Int): LocationFullResponse = apiService.getLocationById(id)
    suspend fun insertLocation(location: LocationEntity) {
        appDatabase.getLocationDao().insertLocation(location)
    }

    fun getAllLocations(): Flow<List<LocationEntity>> = appDatabase.getLocationDao().getAllLocations()
    suspend fun getLocationsByIds(ids: Int): List<LocationEntity> = appDatabase.getLocationDao().getLocationsByIds(ids)
}