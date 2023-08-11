package com.kilica.marvelmobven.presentation.homepage

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kilica.marvelmobven.domain.use_case.get_stories.GetStoriesUseCase
import com.kilica.marvelmobven.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoryViewModel @Inject constructor(
    private val getStoriesUseCase: GetStoriesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(StoriesState())
    val state : State<StoriesState> = _state

    init {
        viewModelScope.launch {
            getStories(0)
        }
    }

    private suspend fun getStories(offset : Int){
        getStoriesUseCase.executeGetStories(offset = offset).collect {
            when(it){
                is Resource.Success ->{
                    _state.value = StoriesState(stories = it.data ?: emptyList(), shouldShowLoading = false)
                }
                is Resource.Error ->{
                    _state.value = StoriesState(error = it.message, shouldShowLoading = false)
                }
                else -> {}
            }
        }
    }

}