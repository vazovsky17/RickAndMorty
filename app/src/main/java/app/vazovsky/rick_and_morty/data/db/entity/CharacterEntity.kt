package app.vazovsky.rick_and_morty.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import app.vazovsky.rick_and_morty.data.db.dao.CharacterDao
import app.vazovsky.rick_and_morty.data.model.responses.LocationResponse
import app.vazovsky.rick_and_morty.data.model.responses.OriginResponse
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = CharacterDao.CHARACTER_TABLE_NAME)
data class CharacterEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "status") val status: String?,
    @ColumnInfo(name = "species") val species: String?,
    @ColumnInfo(name = "type") val type: String?,
    @ColumnInfo(name = "gender") val gender: String?,
    @ColumnInfo(name = "origin") val originResponse: OriginResponse?,
    @ColumnInfo(name = "location") val location: LocationResponse?,
    @ColumnInfo(name = "image") val image: String?,
    @ColumnInfo(name = "episode") val episode: List<String>,
    @ColumnInfo(name = "url") val url: String?,
    @ColumnInfo(name = "created") val created: String?
) : Parcelable