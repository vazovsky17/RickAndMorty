package app.vazovsky.rick_and_morty.presentation.location.list

import android.os.Bundle
import android.view.View
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.databinding.FragmentLocationListBinding
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding

class LocationListFragment : BaseFragment(R.layout.fragment_location_list) {
    private val viewModel: LocationListViewModel by appViewModels()
    private val binding by viewBinding(FragmentLocationListBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}