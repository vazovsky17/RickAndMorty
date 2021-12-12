package app.vazovsky.rick_and_morty.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharactersCount(
    @SerializedName("count") val count: Int
) : Parcelable


@Parcelize
data class CharacterResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("species") val species: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("origin") val originResponse: OriginResponse?,
    @SerializedName("location") val location: LocationResponse?,
    @SerializedName("image") val image: String?,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("url") val url: String?,
    @SerializedName("created") val created: String?
) : Parcelable

@Parcelize
data class OriginResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?,
) : Parcelable

@Parcelize
data class LocationResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?,
) : Parcelable
