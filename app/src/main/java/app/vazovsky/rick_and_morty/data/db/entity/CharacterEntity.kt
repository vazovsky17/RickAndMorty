package app.vazovsky.rick_and_morty.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import app.vazovsky.rick_and_morty.data.db.dao.CharacterDao
import app.vazovsky.rick_and_morty.data.db.entity.converters.ListStringConverter
import app.vazovsky.rick_and_morty.data.model.responses.Location
import app.vazovsky.rick_and_morty.data.model.responses.Origin
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = CharacterDao.CHARACTER_TABLE_NAME)
data class CharacterEntity(
    @PrimaryKey @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "status") var status: String = "",
    @ColumnInfo(name = "species") var species: String = "",
    @ColumnInfo(name = "type") var type: String = "",
    @ColumnInfo(name = "gender") var gender: String = "",
    @ColumnInfo(name = "origin") var origin: Origin = Origin("", ""),
    @ColumnInfo(name = "location") var location: Location = Location("", ""),
    @ColumnInfo(name = "image") var image: String = "",
    @TypeConverters(ListStringConverter::class)
    @ColumnInfo(name = "episode") var episode: List<String> = listOf(),
    @ColumnInfo(name = "url") var url: String = "",
    @ColumnInfo(name = "created") var created: String = ""
) : Parcelable
