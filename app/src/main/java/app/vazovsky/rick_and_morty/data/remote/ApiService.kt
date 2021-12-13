package app.vazovsky.rick_and_morty.data.remote

import app.vazovsky.rick_and_morty.data.model.responses.CharacterResponse
import app.vazovsky.rick_and_morty.data.model.responses.EpisodeResponse
import app.vazovsky.rick_and_morty.data.model.responses.Location
import app.vazovsky.rick_and_morty.data.model.responses.LocationFullResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): CharacterResponse

    @GET("episode/{id}")
    suspend fun getEpisodeById(@Path("id") id: Int): EpisodeResponse

    @GET("location/{id}")
    suspend fun getLocationById(@Path("id") id: Int): LocationFullResponse

}