package app.vazovsky.rick_and_morty.data.remote

import app.vazovsky.rick_and_morty.data.model.CharacterResponse
import app.vazovsky.rick_and_morty.data.model.EpisodeResponse
import app.vazovsky.rick_and_morty.data.model.LocationResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("character")
    suspend fun getCountCharacters(): Int

    @GET("location")
    suspend fun getCountLocations(): Int

    @GET("episode")
    suspend fun getCountEpisodes(): Int

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): CharacterResponse

    @GET("location/{id}")
    suspend fun getLocationById(@Path("id") id: Int): LocationResponse

    @GET("episode/{id}")
    suspend fun getEpisodeById(@Path("id") id: Int): EpisodeResponse
}