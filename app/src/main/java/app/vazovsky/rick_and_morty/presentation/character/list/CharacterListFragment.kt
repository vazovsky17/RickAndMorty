package app.vazovsky.rick_and_morty.presentation.character.list

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.data.model.State
import app.vazovsky.rick_and_morty.databinding.FragmentCharacterListBinding
import app.vazovsky.rick_and_morty.presentation.CustomViewFlipper.Companion.STATE_DATA
import app.vazovsky.rick_and_morty.presentation.ItemDecorator
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import javax.inject.Inject

class CharacterListFragment : BaseFragment(R.layout.fragment_character_list) {
    private val binding by viewBinding(FragmentCharacterListBinding::bind)
    private val viewModel: CharacterListViewModel by appViewModels()
    @Inject lateinit var characterAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadCharacters()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView()
        configureToolbar()
        setViewModelObservers()

        binding.customViewFlipper.setOnErrorClickListener {
            viewModel.loadCharacters()
        }
    }

    private fun setViewModelObservers() = with(binding) {
        viewModel.stateLiveData.observe(viewLifecycleOwner) { state ->
            customViewFlipper.setState(state)
            if (customViewFlipper.displayedChild == STATE_DATA) {
                val items = (state as State.Data<List<CharacterEntity>>).data
                characterAdapter.setItems(items)
            }
        }
    }

    private fun configureRecyclerView() {
        characterAdapter.onItemClick = { character ->
            findNavController().navigate(
                CharacterListFragmentDirections.actionCharacterListFragmentToCharacterDetailFragment(character)
            )
        }
        binding.recyclerView.apply {
            addItemDecoration(ItemDecorator())
            adapter = characterAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
    }

    private fun configureToolbar() = with(binding.toolbar) {
        setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_characters -> true
                R.id.menu_episodes -> {
                    findNavController().navigate(
                        CharacterListFragmentDirections.actionCharacterListFragmentToEpisodeListFragment()
                    )
                    true
                }
                R.id.menu_locations -> {
                    findNavController().navigate(
                        CharacterListFragmentDirections.actionCharacterListFragmentToLocationListFragment()
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

    private fun searchCharacter(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.searchCharacters(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.searchCharacters(newText)
                return false
            }
        })
    }
}