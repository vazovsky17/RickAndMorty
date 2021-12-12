package app.vazovsky.rick_and_morty.data.remote

import app.vazovsky.rick_and_morty.data.model.responses.CharacterResponse
import app.vazovsky.rick_and_morty.data.model.responses.EpisodeResponse
import app.vazovsky.rick_and_morty.data.model.responses.Location
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    /** CHARACTER */
    @GET("character")
    suspend fun getCountCharacters(): Int
    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): CharacterResponse

    /** EPISODE */
    @GET("episode")
    suspend fun getCountEpisodes(): Int
    @GET("episode/{id}")
    suspend fun getEpisodeById(@Path("id") id: Int): EpisodeResponse

    /** LOCATION */
    @GET("location")
    suspend fun getCountLocations(): Int
    @GET("location/{id}")
    suspend fun getLocationById(@Path("id") id: Int): Location

}