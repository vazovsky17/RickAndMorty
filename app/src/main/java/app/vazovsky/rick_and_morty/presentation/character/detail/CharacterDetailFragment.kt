package app.vazovsky.rick_and_morty.presentation.character.detail

import android.os.Bundle
import android.view.View
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.databinding.FragmentCharacterDetailBinding
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding

class CharacterDetailFragment : BaseFragment(R.layout.fragment_character_detail) {
    private val viewModel: CharacterDetailViewModel by appViewModels()
    private val binding by viewBinding(FragmentCharacterDetailBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}