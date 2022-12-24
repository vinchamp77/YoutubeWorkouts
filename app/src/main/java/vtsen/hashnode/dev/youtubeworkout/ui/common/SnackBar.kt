package vtsen.hashnode.dev.youtubeworkout.ui.common

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource

@Composable
fun SnackBar(snackbarHostState: SnackbarHostState, msgResId: Int, onDone: () -> Unit) {
    val msg = stringResource(msgResId)
    LaunchedEffect(msg) {
        snackbarHostState.showSnackbar(
            message = msg,
        )

        onDone()
    }
}

