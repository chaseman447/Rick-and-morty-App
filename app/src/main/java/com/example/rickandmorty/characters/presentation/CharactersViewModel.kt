package com.example.rickandmorty.characters.presentation

import androidx.lifecycle.ViewModel
import com.example.rickandmorty.characters.domain.repository.CharactersRepository
import com.example.rickandmorty.characters.presentation.state.CharactersState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CharactersViewModel(
    coroutineScope: CoroutineScope? = null,
) : ViewModel(),KoinComponent {
    private val repository: CharactersRepository by inject()

    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _state =  MutableStateFlow(CharactersState())
    val state get() = _state.asStateFlow()

    init {
        getCharacters()
    }

    fun getCharacters() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                    isFailure = false,
                    isSuccess = false,
                )
            }

            repository.getCharacters()
                .onSuccess {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        characterList = it.results,
                    )
                }
                .onFailure {
                    _state.value = _state.value.copy(
                        isFailure = true,
                        isLoading = false,
                    )
                }
        }
    }
}