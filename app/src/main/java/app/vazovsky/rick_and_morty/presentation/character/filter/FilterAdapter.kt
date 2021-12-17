package app.vazovsky.rick_and_morty.presentation.character.filter

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject

class FilterAdapter @Inject constructor() : RecyclerView.Adapter<FilterViewHolder>() {

    private val items = mutableListOf<String>()

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FilterViewHolder(parent)
    override fun getItemCount() = items.size

    fun setItems(items: List<String>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }
}