package app.vazovsky.rick_and_morty.presentation.character.list

import android.os.Bundle
import android.view.View
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.databinding.FragmentCharacterListBinding
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding

class CharacterListFragment : BaseFragment(R.layout.fragment_character_list) {
    private val binding by viewBinding(FragmentCharacterListBinding::bind)
    private val viewModelCharacter: CharacterListViewModel by appViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}