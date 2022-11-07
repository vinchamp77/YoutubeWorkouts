package vtsen.hashnode.dev.youtubeworkout.ui.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.DestinationsNavHost
import vtsen.hashnode.dev.youtubeworkout.R
import vtsen.hashnode.dev.youtubeworkout.ui.screens.NavGraphs
import vtsen.hashnode.dev.youtubeworkout.ui.theme.YoutubeWorkoutAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

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
        DestinationsNavHost (
            navGraph = NavGraphs.root,
            modifier = Modifier.padding(
                top = contentPadding.calculateTopPadding(),
                bottom = contentPadding.calculateBottomPadding(),
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    YoutubeWorkoutAppTheme(useSystemUIController = false) {
        MainScreen()
    }
}