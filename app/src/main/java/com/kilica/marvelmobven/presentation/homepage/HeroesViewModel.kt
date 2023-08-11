package com.kilica.marvelmobven.presentation.homepage

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kilica.marvelmobven.domain.use_case.get_heroes.GetHeroUseCase
import com.kilica.marvelmobven.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor(
    private val getHeroUseCase: GetHeroUseCase
    ) : ViewModel() {

        private val _state = mutableStateOf(HeroesState())
        val state : State<HeroesState> = _state

    init {
        viewModelScope.launch {
            getHeroes(0)
            getHeroes(0)
            getHeroes(0)
        }
    }

        private suspend fun getHeroes(offset : Int){
            getHeroUseCase.executeGetHeroes(offset = offset).collect {
                when(it){
                    is Resource.Success ->{
                        _state.value = HeroesState(heroes = it.data ?: emptyList(), shouldShowLoading = false)
                    }
                    is Resource.Error ->{
                        _state.value = HeroesState(error = it.message, shouldShowLoading = false)
                    }
                    else -> {}
                }
            }
        }
}