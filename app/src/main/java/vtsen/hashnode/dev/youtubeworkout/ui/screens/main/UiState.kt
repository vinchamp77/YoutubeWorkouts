package vtsen.hashnode.dev.youtubeworkout.ui.screens.main

sealed interface UiState {
    object Invalid: UiState
    object NoYouTubeApp : UiState
}