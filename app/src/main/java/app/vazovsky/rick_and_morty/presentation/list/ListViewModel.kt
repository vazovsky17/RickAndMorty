package app.vazovsky.rick_and_morty.presentation.list

import androidx.lifecycle.ViewModel
import app.vazovsky.rick_and_morty.data.repository.ApiRepository
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val repository: ApiRepository
) : ViewModel() {
}