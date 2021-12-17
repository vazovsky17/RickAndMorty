package app.vazovsky.rick_and_morty.presentation.character.filter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.rick_and_morty.data.model.filter.Filter
import javax.inject.Inject

class FilterAdapter @Inject constructor() : RecyclerView.Adapter<FilterViewHolder>() {

    private val items = mutableListOf<Filter>()

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FilterViewHolder(parent)
    override fun getItemCount() = items.size

    fun setItems(items: List<Filter>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    fun getCheckedItems() = items.filter { it.checked }.map { it.name }
    fun getAllItems() = items.map { it.name }
}