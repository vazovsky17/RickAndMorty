package app.vazovsky.sampledagger.presentation.sample

import android.os.Bundle
import android.view.View
import app.vazovsky.sampledagger.R
import app.vazovsky.sampledagger.databinding.FragmentSampleBinding
import app.vazovsky.sampledagger.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding

class SampleFragment : BaseFragment(R.layout.fragment_sample) {
    private val binding by viewBinding(FragmentSampleBinding::bind)
    private val viewModel: SampleViewModel by appViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /**
         * Переходы между фрагментами сначала отмечаются в nav_graph.xml,
         * затем осуществляются при помощи <nameFragment>Directions.<actionName>()
         */
    }
}