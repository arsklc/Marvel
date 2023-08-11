package com.kilica.marvelmobven.presentation.homepage

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kilica.marvelmobven.domain.use_case.get_comics.GetComicUseCase
import com.kilica.marvelmobven.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicViewModel @Inject constructor(
    private val getComicUseCase: GetComicUseCase
    ) : ViewModel() {

        private val _state = mutableStateOf(ComicsState())
        val state : State<ComicsState> = _state

    init {
        viewModelScope.launch {
            getComics(0)
            getComics(0)
            getComics(0)
        }
    }

        private suspend fun getComics(offset : Int){
            getComicUseCase.executeGetComics(offset = offset).collect {
                when(it){
                    is Resource.Success ->{
                        _state.value = ComicsState(comics = it.data ?: emptyList(), shouldShowLoading = false)
                    }
                    is Resource.Error ->{
                        _state.value = ComicsState(error = it.message, shouldShowLoading = false)
                    }
                    else -> {}
                }
            }
        }

}
