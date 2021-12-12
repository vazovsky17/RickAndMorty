package app.vazovsky.rick_and_morty.data.repository

import app.vazovsky.rick_and_morty.data.model.responses.EpisodeResponse
import app.vazovsky.rick_and_morty.data.remote.ApiService
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCountEpisodes(): Int = apiService.getCountEpisodes()
    suspend fun getEpisodeById(id: Int): EpisodeResponse = apiService.getEpisodeById(id)
}