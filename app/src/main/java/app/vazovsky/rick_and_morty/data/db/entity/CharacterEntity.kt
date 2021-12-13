package app.vazovsky.rick_and_morty.data.db.entity

import android.graphics.Color
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import app.vazovsky.rick_and_morty.data.db.dao.CharacterDao
import app.vazovsky.rick_and_morty.data.db.entity.converters.ListStringConverter
import app.vazovsky.rick_and_morty.data.model.responses.CharacterResponse
import app.vazovsky.rick_and_morty.data.model.responses.Location
import app.vazovsky.rick_and_morty.data.model.responses.Origin
import kotlinx.parcelize.Parcelize

const val UNDEFINED_VALUE = "undefined"

@Parcelize
@Entity(tableName = CharacterDao.CHARACTER_TABLE_NAME)
data class CharacterEntity(
    @PrimaryKey @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "status") var status: String,
    @ColumnInfo(name = "species") var species: String,
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "gender") var gender: String,
    @ColumnInfo(name = "origin") var origin: Origin,
    @ColumnInfo(name = "location") var location: Location,
    @ColumnInfo(name = "image") var image: String,
    @ColumnInfo(name = "episode") var episode: List<String>,
    @ColumnInfo(name = "url") var url: String,
    @ColumnInfo(name = "created") var created: String
) : Parcelable {
    companion object {
        const val STATUS_ALIVE = "Alive"
        const val STATUS_DEAD = "Dead"
        const val STATUS_UNKNOWN = "Unknown"
    }

    fun getStatusColor(): Int {
        return when (status) {
            STATUS_ALIVE -> Color.GREEN
            STATUS_DEAD -> Color.RED
            STATUS_UNKNOWN -> Color.BLUE
            else -> Color.BLUE
        }
    }
}

fun CharacterResponse.parseToCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        id = id ?: 0,
        name = name ?: UNDEFINED_VALUE,
        status = status ?: UNDEFINED_VALUE,
        species = species ?: UNDEFINED_VALUE,
        type = type ?: UNDEFINED_VALUE,
        gender = gender ?: UNDEFINED_VALUE,
        origin = origin ?: Origin(UNDEFINED_VALUE, UNDEFINED_VALUE),
        location = location ?: Location(UNDEFINED_VALUE, UNDEFINED_VALUE),
        image = image ?: UNDEFINED_VALUE,
        episode = episode,
        url = url ?: UNDEFINED_VALUE,
        created = created ?: UNDEFINED_VALUE
    )
}
