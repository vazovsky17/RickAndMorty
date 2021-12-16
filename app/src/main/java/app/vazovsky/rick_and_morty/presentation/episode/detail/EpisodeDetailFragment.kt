package app.vazovsky.rick_and_morty.presentation.episode.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.data.model.State
import app.vazovsky.rick_and_morty.databinding.FragmentEpisodeDetailBinding
import app.vazovsky.rick_and_morty.presentation.CustomViewFlipper
import app.vazovsky.rick_and_morty.presentation.ItemDecorator
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import app.vazovsky.rick_and_morty.presentation.location.detail.LocationDetailFragmentDirections
import by.kirich1409.viewbindingdelegate.viewBinding
import javax.inject.Inject

class EpisodeDetailFragment : BaseFragment(R.layout.fragment_episode_detail) {
    private val viewModel: EpisodeDetailViewModel by appViewModels()
    private val binding by viewBinding(FragmentEpisodeDetailBinding::bind)

    private val args by navArgs<EpisodeDetailFragmentArgs>()
    private val episode by lazy { args.episode }

    @Inject lateinit var characterAdapter: EpisodeCharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadCharacters(episode.characters)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView()
        configureViews()
        setViewModelObservers()
    }

    private fun setViewModelObservers() = with(binding) {
        viewModel.stateCharacterLiveData.observe(viewLifecycleOwner) { state ->
            customViewFlipper.setState(state)
            if (customViewFlipper.displayedChild == CustomViewFlipper.STATE_DATA) {
                val items = (state as State.Data<List<CharacterEntity>>).data
                characterAdapter.setItems(items)
            }
        }
    }

    private fun configureViews() = with(binding) {
        toolbar.title = episode.name
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        textViewEpisodeId.text = "id: #${episode.id}"
        textViewEpisodeEpisodeCode.text = "episode: ${episode.episode}"
        textViewEpisodeAirDate.text = "air date: ${episode.airDate}"
    }

    private fun configureRecyclerView() {
        characterAdapter.onItemClick = { character ->
            findNavController().navigate(
                EpisodeDetailFragmentDirections.actionEpisodeDetailFragmentToCharacterDetailFragment(character)
            )
        }
        binding.recyclerViewCharacters.apply {
            addItemDecoration(ItemDecorator())
            adapter = characterAdapter
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        }
    }
}