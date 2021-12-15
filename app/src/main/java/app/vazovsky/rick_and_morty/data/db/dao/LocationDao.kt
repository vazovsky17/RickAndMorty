package app.vazovsky.rick_and_morty.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.vazovsky.rick_and_morty.data.db.entity.EpisodeEntity
import app.vazovsky.rick_and_morty.data.db.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {
    companion object {
        const val LOCATION_TABLE_NAME = "locations"
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(location: LocationEntity)

    @Query("SELECT * FROM $LOCATION_TABLE_NAME WHERE id == (:ids) LIMIT 1")
    fun getLocationsByIds(ids: Int): Flow<List<LocationEntity>>

    @Query("SELECT * FROM $LOCATION_TABLE_NAME")
    fun getAllLocations(): Flow<List<LocationEntity>>
}