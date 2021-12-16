package app.vazovsky.rick_and_morty.presentation.episode.detail

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import javax.inject.Inject

class EpisodeCharacterAdapter @Inject constructor() : RecyclerView.Adapter<EpisodeCharacterViewHolder>() {

    private val items = mutableListOf<CharacterEntity>()
    lateinit var onItemClick: (CharacterEntity) -> Unit

    override fun onBindViewHolder(holder: EpisodeCharacterViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EpisodeCharacterViewHolder(parent, onItemClick)
    override fun getItemCount() = items.size

    fun setItems(items: List<CharacterEntity>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }
}