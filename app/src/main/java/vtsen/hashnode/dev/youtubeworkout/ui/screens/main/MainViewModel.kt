package vtsen.hashnode.dev.youtubeworkout.ui.screens.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
): ViewModel() {

    private val youtubeIds = mutableListOf(
        "rI_6l992GrA", //Mad Fit - 30 MIN FULL BODY HIIT (No Jumping + No Equipment)
        "Urx4gMA2-Kw",
        "Urx4gMA2-Kw",
    ).toList().shuffled()

    private val _youtubeIdsStateFlow = MutableStateFlow(youtubeIds)
    val youtubeIdsStateFlow = _youtubeIdsStateFlow.asStateFlow()

    private val _uiStateFlow = MutableStateFlow<UiState>(UiState.Invalid)
    val uiStateFlow = _uiStateFlow.asStateFlow()

    init {

    }

    fun setUiState(uiState: UiState) {
        _uiStateFlow.value = uiState
    }
}