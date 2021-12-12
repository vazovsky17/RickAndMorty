package app.vazovsky.rick_and_morty.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import app.vazovsky.rick_and_morty.data.db.dao.EpisodeDao
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = EpisodeDao.EPISODE_TABLE_NAME)
data class EpisodeEntity(
    @PrimaryKey @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "air_date") var airDate: String = "",
    @ColumnInfo(name = "episode") var episode: String = "",
    @ColumnInfo(name = "characters") var characters: List<String> = listOf(),
    @ColumnInfo(name = "url") var url: String = "",
    @ColumnInfo(name = "created") var created: String = "",
) : Parcelable