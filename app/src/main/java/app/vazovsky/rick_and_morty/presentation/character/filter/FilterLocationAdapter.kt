package app.vazovsky.rick_and_morty.presentation.character.filter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.rick_and_morty.data.model.filter.Filter
import app.vazovsky.rick_and_morty.data.model.filter.FilterLocation
import javax.inject.Inject

class FilterLocationAdapter @Inject constructor() : RecyclerView.Adapter<FilterLocationViewHolder>() {

    private val items = mutableListOf<FilterLocation>()

    override fun onBindViewHolder(holder: FilterLocationViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FilterLocationViewHolder(parent)
    override fun getItemCount() = items.size

    fun setItems(items: List<FilterLocation>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    fun getCheckedItems() = items.filter { it.checked }.map { it.location }
    fun getAllItems() = items.map { it.location }
}