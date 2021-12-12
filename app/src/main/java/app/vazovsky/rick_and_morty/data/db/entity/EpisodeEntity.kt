package app.vazovsky.rick_and_morty.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import app.vazovsky.rick_and_morty.data.db.dao.EpisodeDao
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = EpisodeDao.EPISODE_TABLE_NAME)
data class EpisodeEntity(
    @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "air_date") val airDate: String?,
    @ColumnInfo(name = "episode") val episode: String?,
    @ColumnInfo(name = "characters") val characters: List<String>?,
    @ColumnInfo(name = "url") val url: String?,
    @ColumnInfo(name = "created") val created: String?,
) : Parcelable