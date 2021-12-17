package app.vazovsky.rick_and_morty.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {
    companion object {
        const val CHARACTER_TABLE_NAME = "characters"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterEntity)

    @Query("SELECT * FROM $CHARACTER_TABLE_NAME WHERE $COLUMN_NAME LIKE  '%' || :search || '%'")
    suspend fun searchCharacters(search: String): List<CharacterEntity>

    @Query("SELECT * FROM $CHARACTER_TABLE_NAME WHERE $COLUMN_ID in (:ids)")
    suspend fun getCharactersByIds(ids: List<Int>): List<CharacterEntity>

    @Query("SELECT * FROM $CHARACTER_TABLE_NAME")
    fun getAllCharacters(): Flow<List<CharacterEntity>>


}