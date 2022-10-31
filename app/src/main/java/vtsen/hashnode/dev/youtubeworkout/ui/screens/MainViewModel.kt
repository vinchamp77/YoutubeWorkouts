package vtsen.hashnode.dev.youtubeworkout.ui.screens

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
): ViewModel() {

    private val youtubeIds = mutableListOf(
        "rI_6l992GrA",
        "Urx4gMA2-Kw"
    ).toList().shuffled()

    private val _youtubeIdsStateFlow = MutableStateFlow(youtubeIds)
    val youtubeIdsStateFlow = _youtubeIdsStateFlow.asStateFlow()

    init {

    }
}