package app.vazovsky.rick_and_morty.presentation.episode.list

import android.os.Bundle
import android.view.View
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.databinding.FragmentEpisodeListBinding
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding

class EpisodeListFragment : BaseFragment(R.layout.fragment_episode_list) {
    private val viewModel: EpisodeListViewModel by appViewModels()
    private val binding by viewBinding(FragmentEpisodeListBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}