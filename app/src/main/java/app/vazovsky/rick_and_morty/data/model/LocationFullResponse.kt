package app.vazovsky.rick_and_morty.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationFullResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("dimension") val dimension: String?,
    @SerializedName("residents") val residents: List<String>?,
    @SerializedName("url") val url: String?,
    @SerializedName("created") val created: String?,
) : Parcelable