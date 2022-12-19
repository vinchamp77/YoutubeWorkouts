package vtsen.hashnode.dev.youtubeworkout.ui.screens.videos

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import vtsen.hashnode.dev.youtubeworkout.ui.screens.destinations.YouTubeScreenDestination
import vtsen.hashnode.dev.youtubeworkout.ui.screens.main.MainViewModel

@RootNavGraph(start = true)
@Destination
@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun VideosScreen(
    viewModel: MainViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
) {

    val youtubeIds by viewModel.youtubeIdsStateFlow.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(items = youtubeIds) { youtubeId ->
            VideoCard(
                youtubeId,
                onClick =  {
                    navigator.navigate(YouTubeScreenDestination(youtubeId))
                },

            )
        }
    }
}