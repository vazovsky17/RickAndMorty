package app.vazovsky.rick_and_morty.data.model.responses

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.TypeConverters
import app.vazovsky.rick_and_morty.data.db.entity.converters.OriginConverter
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Characters(
    @SerializedName("info") val info: Info?
) : Parcelable

@Parcelize
data class Info(
    @SerializedName("count") val count: Int?,
) : Parcelable


@Parcelize
data class CharacterResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("species") val species: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("origin") val origin: Origin?,
    @SerializedName("location") val location: Location?,
    @SerializedName("image") val image: String?,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("url") val url: String?,
    @SerializedName("created") val created: String?
) : Parcelable

@Parcelize
data class Origin(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?,
) : Parcelable

@Parcelize
data class Location(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?,
) : Parcelable
