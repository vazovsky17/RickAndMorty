package app.vazovsky.rick_and_morty.data.repository


import app.vazovsky.rick_and_morty.data.db.AppDatabase
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.data.db.entity.Location
import app.vazovsky.rick_and_morty.data.model.responses.CharacterResponse
import app.vazovsky.rick_and_morty.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) {
    suspend fun getCharacterById(id: Int): CharacterResponse = apiService.getCharacterById(id)

    suspend fun insertCharacter(character: CharacterEntity) = appDatabase.getCharacterDao().insertCharacter(character)
    suspend fun getCharactersByIds(ids: List<Int>): List<CharacterEntity> = appDatabase.getCharacterDao().getCharactersByIds(ids)
    suspend fun searchCharacters(search: String): List<CharacterEntity> = appDatabase.getCharacterDao().searchCharacters(search)

    fun getAllCharacters(): Flow<List<CharacterEntity>> = appDatabase.getCharacterDao().getAllCharacters()

    /** Query Filter */
    suspend fun getStatusList(): List<String> = appDatabase.getCharacterDao().getStatusList()
    suspend fun getSpeciesList(): List<String> = appDatabase.getCharacterDao().getSpeciesList()
    suspend fun getTypeList(): List<String> = appDatabase.getCharacterDao().getTypeList()
    suspend fun getGenderList(): List<String> = appDatabase.getCharacterDao().getGenderList()
    suspend fun getLocationList(): List<Location> = appDatabase.getCharacterDao().getLocationList()
    suspend fun filterCharacters(
        status: List<String>,
        species: List<String>,
        type: List<String>,
        gender: List<String>,
        origin: List<String>,
        location: List<String>
    ): List<CharacterEntity> = appDatabase.getCharacterDao().filterCharacters(status, species, type, gender, origin, location)
}