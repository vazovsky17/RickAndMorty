package app.vazovsky.rick_and_morty.data.repository

import app.vazovsky.rick_and_morty.data.model.responses.CharacterResponse
import app.vazovsky.rick_and_morty.data.remote.ApiService
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCountCharacters(): Int = apiService.getCountCharacters()
    suspend fun getCharacterById(id: Int): CharacterResponse = apiService.getCharacterById(id)
}