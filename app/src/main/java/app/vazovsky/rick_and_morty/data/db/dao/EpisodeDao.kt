package app.vazovsky.rick_and_morty.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.vazovsky.rick_and_morty.data.db.entity.EpisodeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EpisodeDao {
    companion object {
        const val EPISODE_TABLE_NAME = "episodes"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEpisode(episode: EpisodeEntity)

    @Query("SELECT * FROM $EPISODE_TABLE_NAME WHERE $COLUMN_NAME LIKE  '%' || :search || '%'")
    suspend fun searchEpisodes(search: String): List<EpisodeEntity>

    @Query("SELECT * FROM $EPISODE_TABLE_NAME WHERE $COLUMN_ID in (:ids)")
    suspend fun getEpisodesByIds(ids: List<Int>): List<EpisodeEntity>

    @Query("SELECT * FROM $EPISODE_TABLE_NAME")
    fun getAllEpisodes(): Flow<List<EpisodeEntity>>
}