package app.vazovsky.rick_and_morty.presentation.location.detail

import android.os.Bundle
import android.view.View
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.databinding.FragmentLocationDetailBinding
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding

class LocationDetailFragment : BaseFragment(R.layout.fragment_location_detail) {
    private val viewModel: LocationDetailViewModel by appViewModels()
    private val binding by viewBinding(FragmentLocationDetailBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}