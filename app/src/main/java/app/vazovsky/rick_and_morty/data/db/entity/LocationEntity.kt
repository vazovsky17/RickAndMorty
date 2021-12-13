package app.vazovsky.rick_and_morty.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import app.vazovsky.rick_and_morty.data.db.dao.LocationDao
import app.vazovsky.rick_and_morty.data.model.responses.LocationFullResponse
import app.vazovsky.rick_and_morty.data.model.responses.LocationResponse
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = LocationDao.LOCATION_TABLE_NAME)
data class LocationEntity(
    @PrimaryKey @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "dimension") var dimension: String,
    @ColumnInfo(name = "residents") var residents: List<Int>
) : Parcelable

fun LocationFullResponse.parseToLocationEntity(): LocationEntity {
    return LocationEntity(
        id = id ?: 0,
        name = name ?: UNDEFINED_VALUE,
        type = type ?: UNDEFINED_VALUE,
        dimension = dimension ?: UNDEFINED_VALUE,
        residents = residents?.map { url ->
            val index = url.lastIndexOf("/")
            url.substring(index + 1).toInt()
        } ?: listOf()
    )
}