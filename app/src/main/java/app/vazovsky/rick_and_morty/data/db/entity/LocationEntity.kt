package app.vazovsky.rick_and_morty.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import app.vazovsky.rick_and_morty.data.db.dao.LocationDao
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = LocationDao.LOCATION_TABLE_NAME)
data class LocationEntity(
    @PrimaryKey @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "type") var type: String = "",
    @ColumnInfo(name = "dimension") var dimension: String = "",
    @ColumnInfo(name = "residents") var residents: List<String> = listOf(),
    @ColumnInfo(name = "url") var url: String = "",
    @ColumnInfo(name = "created") var created: String = "",
) : Parcelable