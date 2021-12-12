package app.vazovsky.rick_and_morty.data.db.entity.converters

import androidx.room.TypeConverter

class ListStringConverter {
    @TypeConverter
    fun fromListString(data: List<String>): String {
        return if (data.isEmpty()) {
            ""
        } else buildString {
            for (episode in data) {
                append(episode)
            }

        }
    }

    @TypeConverter
    fun toListString(data: String): List<String> {
        return data.split(",").toList()
    }
}