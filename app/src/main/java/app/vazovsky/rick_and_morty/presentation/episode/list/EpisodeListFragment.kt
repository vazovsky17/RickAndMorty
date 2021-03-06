package app.vazovsky.rick_and_morty.presentation.episode.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.findNavController
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.data.db.entity.EpisodeEntity
import app.vazovsky.rick_and_morty.data.model.State
import app.vazovsky.rick_and_morty.databinding.FragmentEpisodeListBinding
import app.vazovsky.rick_and_morty.presentation.CustomViewFlipper.Companion.STATE_DATA
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import app.vazovsky.rick_and_morty.presentation.ItemDecorator
import by.kirich1409.viewbindingdelegate.viewBinding
import javax.inject.Inject

class EpisodeListFragment : BaseFragment(R.layout.fragment_episode_list) {
    private val viewModel: EpisodeListViewModel by appViewModels()
    private val binding by viewBinding(FragmentEpisodeListBinding::bind)
    @Inject lateinit var episodeAdapter: EpisodeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadEpisodes()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView()
        configureToolbar()
        setViewModelObservers()

        binding.customViewFlipper.setOnErrorClickListener {
            viewModel.loadEpisodes()
        }
    }

    private fun setViewModelObservers() = with(viewModel) {
        stateLiveData.observe(viewLifecycleOwner) { state ->
            binding.apply {
                customViewFlipper.setState(state)
                if (customViewFlipper.displayedChild == STATE_DATA) {
                    val items = (state as State.Data<List<EpisodeEntity>>).data
                    episodeAdapter.setItems(items)
                }
            }
        }
    }


    private fun configureRecyclerView() {
        episodeAdapter.onItemClick = { episode ->
            findNavController().navigate(
                EpisodeListFragmentDirections.actionEpisodeListFragmentToEpisodeDetailFragment(episode)
            )
        }
        binding.recyclerView.apply {
            addItemDecoration(ItemDecorator())
            adapter = episodeAdapter
        }
    }

    private fun configureToolbar() {
        binding.toolbar.apply {
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_characters -> {
                        findNavController().navigate(
                            EpisodeListFragmentDirections.actionEpisodeListFragmentToCharacterListFragment()
                        )
                        true
                    }
                    R.id.menu_episodes -> true
                    R.id.menu_locations -> {
                        findNavController().navigate(
                            EpisodeListFragmentDirections.actionEpisodeListFragmentToLocationListFragment()
                        )
                        true
                    }
                    R.id.menu_search -> {
                        searchCharacter(it.actionView as SearchView)
                        true
                    }
                    else -> false
                }
            }
        }
    }

    private fun searchCharacter(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.searchEpisodes(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.searchEpisodes(newText)
                return false
            }
        })
    }
}