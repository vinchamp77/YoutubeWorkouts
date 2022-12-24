package vtsen.hashnode.dev.youtubeworkout.ui.screens.videos

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import vtsen.hashnode.dev.youtubeworkout.ui.screens.main.UiState

@Composable
fun VideosScreen(
    modifier: Modifier,
    youtubeIds: List<String>,
    onSetUiState: (UiState) -> Unit,
) {

    val context = LocalContext.current

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(items = youtubeIds) { youtubeId ->
            VideoCard(
                youtubeId,
                onClick =  {

                    val url = "https://youtu.be/$youtubeId"
                    val uri = Uri.parse(url)
                    val intent = Intent(Intent.ACTION_VIEW, uri)

                    try {
                        intent.setPackage("com.google.android.apps.youtube")
                        ContextCompat.startActivity(context, intent, null)

                    } catch (e: ActivityNotFoundException) {

                        try {
                            intent.setPackage(null)
                            ContextCompat.startActivity(context, intent, null)

                        } catch (e: ActivityNotFoundException) {
                            onSetUiState(UiState.NoYouTubeApp)
                        }
                    }
                },

            )
        }
    }
}

