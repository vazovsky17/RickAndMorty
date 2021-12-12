package app.vazovsky.rick_and_morty.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import app.vazovsky.rick_and_morty.data.db.dao.LocationDao
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = LocationDao.LOCATION_TABLE_NAME)
data class LocationEntity(
    @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "type") val type: String?,
    @ColumnInfo(name = "dimension") val dimension: String?,
    @ColumnInfo(name = "residents") val residents: List<String>?,
    @ColumnInfo(name = "url") val url: String?,
    @ColumnInfo(name = "created") val created: String?,
) : Parcelable