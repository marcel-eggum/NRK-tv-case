package no.nrk.tv.ui.direct

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import no.nrk.tv.data.model.LiveItemModel
import no.nrk.tv.data.repository.DirectRepository
import no.nrk.tv.type.UiStateType

data class DirectUiState(
    val uiStateType: UiStateType = UiStateType.DEFAULT,
    val feedList: List<LiveItemModel> = emptyList()
)

class DirectViewModel(
    private val directRepository: DirectRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DirectUiState())
    val uiState: StateFlow<DirectUiState> = _uiState.asStateFlow()

    fun fetchFeed() {
        _uiState.update { it.copy(uiStateType = UiStateType.LOADING) }

        viewModelScope.launch {
            directRepository
                .getFeed()
                .onSuccess { feedList ->
                    _uiState.update {
                        it.copy(
                            uiStateType = UiStateType.DEFAULT,
                            feedList = feedList
                        )
                    }
                }
                .onFailure {
                    _uiState.update { it.copy(uiStateType = UiStateType.ERROR) }
                }
        }
    }

}