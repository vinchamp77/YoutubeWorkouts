package vtsen.hashnode.dev.youtubeworkout.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import vtsen.hashnode.dev.youtubeworkout.R
import vtsen.hashnode.dev.youtubeworkout.ui.theme.PaddingSmall

@Composable
fun VideoCard(youtubeId: String) {

    val imageUrl = remember {"https://img.youtube.com/vi/" + youtubeId + "/0.jpg" }

    Card(
        modifier = Modifier
            .padding(PaddingSmall)
        ,
        shape = RoundedCornerShape(5)
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .placeholder(R.drawable.loading_animation)
                .build(),
            contentDescription = "",
            modifier = Modifier
                .height(350.dp)
                .fillMaxSize()
            ,
            contentScale = ContentScale.FillBounds
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun VideoCardPreview() {
    VideoCard(
        youtubeId = "rI_6l992GrA",
    )
}