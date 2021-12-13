package app.vazovsky.rick_and_morty.presentation.character.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.databinding.FragmentCharacterDetailBinding
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide

class CharacterDetailFragment : BaseFragment(R.layout.fragment_character_detail) {
    private val viewModel: CharacterDetailViewModel by appViewModels()
    private val binding by viewBinding(FragmentCharacterDetailBinding::bind)

    private val args by navArgs<CharacterDetailFragmentArgs>()
    private val character by lazy { args.character }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            Glide.with(requireContext())
                .asBitmap()
                .centerCrop()
                .load(character.image)
                .placeholder(R.drawable.placeholder)
                .into(imageViewToolbarBackground)
            textViewCharacterName.text = character.name
            textViewCharacterId.text = "id: #${character.id}"
            textViewCharacterSpecies.text = "species: ${character.species}"
            textViewCharacterStatus.text = "status: ${character.status}"
            textViewCharacterType.text = "type: ${if (character.type.isEmpty()) "standard" else character.type}"
            textViewCharacterGender.text = "gender: ${character.gender}"
            textViewCharacterOrigin.text = "origin:\n${character.origin.name}"
            textViewCharacterLocation.text = "location:\n${character.location.name}"
            textViewCharacterEpisode.text = "episodes:\n${character.episode}"
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}