package app.vazovsky.rick_and_morty.presentation.location.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.data.db.entity.LocationEntity
import javax.inject.Inject

class LocationAdapter @Inject constructor() : RecyclerView.Adapter<LocationViewHolder>() {

    private val items = mutableListOf<LocationEntity>()
    lateinit var onItemClick: (LocationEntity) -> Unit

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LocationViewHolder(parent, onItemClick)
    override fun getItemCount() = items.size

    fun setItems(items: List<LocationEntity>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }
}