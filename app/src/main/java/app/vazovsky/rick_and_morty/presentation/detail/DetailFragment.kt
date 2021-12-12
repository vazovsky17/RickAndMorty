package app.vazovsky.rick_and_morty.presentation.detail

import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.databinding.FragmentDetailBinding
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding

class DetailFragment : BaseFragment(R.layout.fragment_detail) {
    private val viewModel: DetailViewModel by appViewModels()
    private val binding by viewBinding(FragmentDetailBinding::bind)
}