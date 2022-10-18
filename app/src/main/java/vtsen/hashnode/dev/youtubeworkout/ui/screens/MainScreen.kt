package vtsen.hashnode.dev.youtubeworkout.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.media3.ui.PlayerView
import vtsen.hashnode.dev.youtubeworkout.ui.theme.YoutubeWorkoutAppTheme

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {

    AndroidView(
        factory = { context ->
            PlayerView(context).apply {
                player = viewModel.player
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    YoutubeWorkoutAppTheme(useSystemUIController = false) {
        MainScreen()
    }
}