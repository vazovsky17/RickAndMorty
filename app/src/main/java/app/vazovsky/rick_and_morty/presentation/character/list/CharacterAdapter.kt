package app.vazovsky.rick_and_morty.presentation.character.list

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import javax.inject.Inject

class CharacterAdapter @Inject constructor() : RecyclerView.Adapter<CharacterViewHolder>() {

    private val items = mutableListOf<CharacterEntity>()
    lateinit var onItemClick: (CharacterEntity) -> Unit

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(parent, onItemClick)
    }

    override fun getItemCount() = items.size

    fun setItems(items: List<CharacterEntity>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }
}