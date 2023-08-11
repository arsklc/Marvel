package com.kilica.marvelmobven.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kilica.marvelmobven.domain.use_case.get_story_detail.GetStoryDetailUseCase
import com.kilica.marvelmobven.util.Constants.ID
import com.kilica.marvelmobven.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoryDetailViewModel @Inject constructor(
    private val getStoryDetailUseCase: GetStoryDetailUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(StoryDetailState())
    val state: State<StoryDetailState> = _state

    init {
        savedStateHandle.get<String>(ID)?.let {
            getStoryDetail(it)
        }
    }


    private fun getStoryDetail(id: String) {
        viewModelScope.launch {
            getStoryDetailUseCase.executeGetStoryDetail(id = id).collect {
                when (it) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(story = it.data, isLoading = false)
                    }

                    is Resource.Error -> {
                        _state.value =
                            _state.value.copy(error = it.message ?: "", isLoading = false)
                    }

                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isLoading = true)
                    }
                }
            }
        }
    }
    fun clear() {
        _state.value = StoryDetailState()
    }
}