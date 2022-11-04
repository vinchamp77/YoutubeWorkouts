package vtsen.hashnode.dev.youtubeworkout.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import vtsen.hashnode.dev.youtubeworkout.R
import vtsen.hashnode.dev.youtubeworkout.ui.theme.YoutubeWorkoutAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) { contentPadding ->
        VideosScreen(viewModel, contentPadding)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    YoutubeWorkoutAppTheme(useSystemUIController = false) {
        MainScreen()
    }
}