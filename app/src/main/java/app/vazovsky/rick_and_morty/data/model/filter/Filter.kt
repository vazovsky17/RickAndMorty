package app.vazovsky.rick_and_morty.data.model.filter

import app.vazovsky.rick_and_morty.data.db.entity.Location


data class Filter(
    val name: String,
    var checked: Boolean = false
)

data class FilterLocation(
    val location: Location,
    var checked: Boolean = false
)
