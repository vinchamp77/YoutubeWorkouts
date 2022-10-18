package vtsen.hashnode.dev.youtubeworkout.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import vtsen.hashnode.dev.youtubeworkout.ui.theme.YoutubeWorkoutAppTheme

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    YoutubeWorkoutAppTheme(useSystemUIController = false) {
        MainScreen()
    }
}