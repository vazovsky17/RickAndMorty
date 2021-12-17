package app.vazovsky.rick_and_morty.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.data.db.entity.Location
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {
    companion object {
        const val CHARACTER_TABLE_NAME = "characters"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_STATUS = "status"
        const val COLUMN_SPECIES = "species"
        const val COLUMN_TYPE = "type"
        const val COLUMN_GENDER = "gender"
        const val COLUMN_ORIGIN = "origin"
        const val COLUMN_LOCATION = "location"
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterEntity)

    @Query("SELECT * FROM $CHARACTER_TABLE_NAME WHERE $COLUMN_NAME LIKE  '%' || :search || '%'")
    suspend fun searchCharacters(search: String): List<CharacterEntity>

    @Query("SELECT * FROM $CHARACTER_TABLE_NAME WHERE $COLUMN_ID in (:ids)")
    suspend fun getCharactersByIds(ids: List<Int>): List<CharacterEntity>

    @Query("SELECT * FROM $CHARACTER_TABLE_NAME")
    fun getAllCharacters(): Flow<List<CharacterEntity>>

    /** Query Filter */
    @Query("SELECT $COLUMN_STATUS FROM $CHARACTER_TABLE_NAME GROUP BY $COLUMN_STATUS")
    suspend fun getStatusList(): List<String>

    @Query("SELECT $COLUMN_SPECIES FROM $CHARACTER_TABLE_NAME GROUP BY $COLUMN_SPECIES")
    suspend fun getSpeciesList(): List<String>

    @Query("SELECT $COLUMN_TYPE FROM $CHARACTER_TABLE_NAME GROUP BY $COLUMN_TYPE")
    suspend fun getTypeList(): List<String>

    @Query("SELECT $COLUMN_GENDER FROM $CHARACTER_TABLE_NAME GROUP BY $COLUMN_GENDER")
    suspend fun getGenderList(): List<String>

    @Query("SELECT $COLUMN_LOCATION FROM $CHARACTER_TABLE_NAME GROUP BY $COLUMN_LOCATION")
    suspend fun getLocationList(): List<Location>

}