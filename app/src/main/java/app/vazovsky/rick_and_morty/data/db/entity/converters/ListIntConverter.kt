package app.vazovsky.rick_and_morty.data.db.entity.converters

import android.util.Log
import androidx.room.TypeConverter

class ListIntConverter {
    @TypeConverter
    fun fromListInt(data: List<Int>): String {
        return if (data.isEmpty()) {
            ""
        } else buildString {
            for (i in data.indices) {
                append("${data[i]}" + (if (i == data.size - 1) "" else ","))
            }
        }
    }

    @TypeConverter
    fun toListInt(data: String): List<Int> {
        return if (data == "") listOf() else data.split(",").toList().map { it.toInt() }
    }
}