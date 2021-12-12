package app.vazovsky.rick_and_morty.data.model.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EpisodeResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("air_date") val airDate: String?,
    @SerializedName("episode") val episode: String?,
    @SerializedName("characters") val characters: List<String>?,
    @SerializedName("url") val url: String?,
    @SerializedName("created") val created: String?,
) : Parcelable
