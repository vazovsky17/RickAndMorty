package app.vazovsky.rick_and_morty.data.repository

import app.vazovsky.rick_and_morty.data.db.AppDatabase
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.data.model.responses.CharacterResponse
import app.vazovsky.rick_and_morty.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) {
    suspend fun getCharacterById(id: Int): CharacterResponse = apiService.getCharacterById(id)
    suspend fun insertCharacter(character: CharacterEntity) {
        appDatabase.getCharacterDao().insertCharacter(character)
    }

    fun getAllCharacters(): Flow<List<CharacterEntity>> = appDatabase.getCharacterDao().getAllCharacters()
    fun getCharactersByIds(ids: List<Int>): Flow<List<CharacterEntity>> = appDatabase.getCharacterDao().getCharactersByIds(ids)
}