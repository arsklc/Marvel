package com.kilica.marvelmobven.presentation.homepage

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kilica.marvelmobven.domain.use_case.get_creators.GetCreatorUseCase
import com.kilica.marvelmobven.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreatorViewModel @Inject constructor(
    private val getCreatorUseCase: GetCreatorUseCase
    ) : ViewModel() {

        private val _state = mutableStateOf(CreatorsState())
        val state : State<CreatorsState> = _state

    init {
        viewModelScope.launch {
            getCreators(0)
        }
    }

        private suspend fun getCreators(offset : Int){
            getCreatorUseCase.executeGetCreators(offset = offset).collect {
                when(it){
                    is Resource.Success ->{
                        _state.value = CreatorsState(creators = it.data ?: emptyList(), shouldShowLoading = false)
                    }
                    is Resource.Error ->{
                        _state.value = CreatorsState(error = it.message, shouldShowLoading = false)
                    }
                    else -> {}
                }
            }
        }

}
