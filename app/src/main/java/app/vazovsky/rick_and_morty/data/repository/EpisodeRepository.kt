package app.vazovsky.rick_and_morty.data.repository

import app.vazovsky.rick_and_morty.data.db.AppDatabase
import app.vazovsky.rick_and_morty.data.db.entity.EpisodeEntity
import app.vazovsky.rick_and_morty.data.model.responses.EpisodeResponse
import app.vazovsky.rick_and_morty.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) {
    suspend fun getEpisodeById(id: Int): EpisodeResponse = apiService.getEpisodeById(id)
    suspend fun insertEpisode(episode: EpisodeEntity) {
        appDatabase.getEpisodeDao().insertEpisode(episode)
    }

    fun getAllEpisodes(): Flow<List<EpisodeEntity>> = appDatabase.getEpisodeDao().getAllEpisodes()
    fun getEpisodesByIds(ids: List<Int>): Flow<List<EpisodeEntity>> = appDatabase.getEpisodeDao().getEpisodesByIds(ids)
}