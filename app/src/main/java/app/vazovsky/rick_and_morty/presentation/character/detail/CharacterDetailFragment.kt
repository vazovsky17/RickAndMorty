package app.vazovsky.rick_and_morty.presentation.character.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.data.db.entity.EpisodeEntity
import app.vazovsky.rick_and_morty.data.db.entity.LocationEntity
import app.vazovsky.rick_and_morty.data.model.State
import app.vazovsky.rick_and_morty.databinding.FragmentCharacterDetailBinding
import app.vazovsky.rick_and_morty.presentation.CustomViewFlipper
import app.vazovsky.rick_and_morty.presentation.ItemDecorator
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import app.vazovsky.rick_and_morty.presentation.character.detail.CharacterDetailViewModel.Companion.LOCATION
import app.vazovsky.rick_and_morty.presentation.character.detail.CharacterDetailViewModel.Companion.ORIGIN
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import javax.inject.Inject

class CharacterDetailFragment : BaseFragment(R.layout.fragment_character_detail) {
    private val viewModel: CharacterDetailViewModel by appViewModels()
    private val binding by viewBinding(FragmentCharacterDetailBinding::bind)

    private val args by navArgs<CharacterDetailFragmentArgs>()
    private val character by lazy { args.character }

    @Inject lateinit var episodeAdapter: CharacterEpisodeAdapter
    private var listOfLocations = mutableListOf<LocationEntity?>(null, null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadEpisodes(character.episode)
        viewModel.loadLocation(
            mapOf(
                ORIGIN to character.origin.id,
                LOCATION to character.location.id
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView()
        configureViews()
        setViewModelObservers()

        binding.customViewFlipper.setOnErrorClickListener {
            viewModel.loadEpisodes(character.episode)
        }
    }

    private fun setViewModelObservers() = with(binding) {
        viewModel.stateEpisodeLiveData.observe(viewLifecycleOwner) { state ->
            customViewFlipper.setState(state)
            if (customViewFlipper.displayedChild == CustomViewFlipper.STATE_DATA) {
                val items = (state as State.Data<List<EpisodeEntity>>).data
                episodeAdapter.setItems(items)
            }
        }
        viewModel.stateLocationLiveData.observe(viewLifecycleOwner) { state ->
            if (state is State.Data<MutableList<LocationEntity?>>) {
                Log.d("LOL", state.data.toString())
                listOfLocations = state.data
            } else if (state is State.Error) {
                Log.d("LOL", state.error.message.toString())
            }
        }
    }

    private fun configureRecyclerView() {
        episodeAdapter.onItemClick = { episode ->
            findNavController().navigate(
                CharacterDetailFragmentDirections.actionCharacterDetailFragmentToEpisodeDetailFragment(episode)
            )
        }
        binding.recyclerViewEpisodes.apply {
            addItemDecoration(ItemDecorator())
            adapter = episodeAdapter
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        }
    }

    private fun configureViews() = with(binding) {
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

        textViewCharacterOrigin.apply {
            text = "origin:\n${character.origin.name}"
            setOnClickListener {
                if (listOfLocations[0] != null) {
                    findNavController().navigate(
                        CharacterDetailFragmentDirections.actionCharacterDetailFragmentToLocationDetailFragment(listOfLocations[0]!!)
                    )
                }
            }
        }
        textViewCharacterLocation.apply {
            text = "location:\n${character.location.name}"
            setOnClickListener {
                if (listOfLocations[1] != null) {
                    findNavController().navigate(
                        CharacterDetailFragmentDirections.actionCharacterDetailFragmentToLocationDetailFragment(listOfLocations[1]!!)
                    )
                }
            }
        }
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}
