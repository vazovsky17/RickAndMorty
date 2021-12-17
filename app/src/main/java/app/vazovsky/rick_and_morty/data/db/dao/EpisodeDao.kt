package app.vazovsky.rick_and_morty.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.data.db.entity.EpisodeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EpisodeDao {
    companion object {
        const val EPISODE_TABLE_NAME = "episodes"
        const val COLUMN_ID = "id"
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEpisode(episode: EpisodeEntity)

    @Query("SELECT * FROM $EPISODE_TABLE_NAME WHERE $COLUMN_ID in (:ids)")
    fun getEpisodesByIds(ids: List<Int>): Flow<List<EpisodeEntity>>

    @Query("SELECT * FROM $EPISODE_TABLE_NAME")
    fun getAllEpisodes(): Flow<List<EpisodeEntity>>

}