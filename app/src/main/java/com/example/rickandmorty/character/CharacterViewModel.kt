package com.example.rickandmorty.character

import androidx.lifecycle.ViewModel
import com.example.rickandmorty.characters.domain.repository.CharactersRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CharacterViewModel(
    coroutineScope: CoroutineScope? = null,
) : ViewModel(),KoinComponent {
    private val repository: CharactersRepository by inject()

    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _state =  MutableStateFlow(CharacterState())
    val state get() = _state.asStateFlow()

    fun getCharacter(id : String) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                    isFailure = false,
                    isSuccess = false,
                )
            }

            repository.getCharacterById(id)
                .onSuccess {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        selectedCharacter = it,
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