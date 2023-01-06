package vtsen.hashnode.dev.youtubeworkout.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import vtsen.hashnode.dev.youtubeworkout.R
import vtsen.hashnode.dev.youtubeworkout.ui.common.SnackBar
import vtsen.hashnode.dev.youtubeworkout.ui.screens.videos.VideosScreen
import vtsen.hashnode.dev.youtubeworkout.ui.theme.YoutubeWorkoutAppTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLifecycleComposeApi::class)
@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {

    val snackbarHostState = remember { SnackbarHostState() }
    val youtubeIds by viewModel.youtubeIdsStateFlow.collectAsStateWithLifecycle()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.thirty_minute_workouts),
                        style = MaterialTheme.typography.headlineLarge,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.secondaryContainer
    ) { contentPadding ->

        VideosScreen(
            modifier = Modifier.padding(
                top = contentPadding.calculateTopPadding(),
                bottom = contentPadding.calculateBottomPadding(),
            ),
            youtubeIds,
            onSetUiState = viewModel::setUiState
        )
    }

    val uiState: UiState by viewModel.uiStateFlow.collectAsStateWithLifecycle()
    SnackBar(uiState, snackbarHostState, viewModel::setUiState)
}

@Composable
private fun SnackBar(
    uiState: UiState,
    snackbarHostState: SnackbarHostState,
    onSetUiState: (UiState) -> Unit,
) {
    if(uiState is UiState.NoYouTubeApp) {
        SnackBar(
            snackbarHostState,
            R.string.no_youtube_app,
            onDone = {
                onSetUiState(UiState.Invalid)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    YoutubeWorkoutAppTheme(useSystemUIController = false) {
        MainScreen()
    }
}