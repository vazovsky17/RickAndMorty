package app.vazovsky.rick_and_morty.presentation.character.filter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.databinding.ItemCheckboxBinding
import app.vazovsky.rick_and_morty.databinding.ItemSimpleBinding
import by.kirich1409.viewbindingdelegate.viewBinding

class FilterViewHolder(
    parent: ViewGroup,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_checkbox, parent, false)
) {
    private val binding by viewBinding(ItemCheckboxBinding::bind)
    fun bind(name: String) = with(binding) {
        checkbox.text = name
    }
}