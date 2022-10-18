package vtsen.hashnode.dev.youtubeworkout.ui.screens

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@UnstableApi
@HiltViewModel
class MainViewModel @Inject constructor(
    val player: Player,
): ViewModel() {

    init {
        player.prepare()

        /*Note: does not work*/
        val uri = Uri.parse("https://youtu.be/VRnUojlA4B8")
        val mediaSource = ProgressiveMediaSource.Factory(DefaultHttpDataSource.Factory())
            .createMediaSource(MediaItem.fromUri(uri))

        player.addMediaItem(mediaSource.mediaItem)
    }

    override fun onCleared() {
        super.onCleared()

        player.release()
    }

}