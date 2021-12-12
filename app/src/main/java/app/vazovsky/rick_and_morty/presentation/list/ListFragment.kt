package app.vazovsky.rick_and_morty.presentation.list

import android.os.Bundle
import android.view.View
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.databinding.FragmentListBinding
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding

class ListFragment : BaseFragment(R.layout.fragment_list) {
    private val binding by viewBinding(FragmentListBinding::bind)
    private val viewModel: ListViewModel by appViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}