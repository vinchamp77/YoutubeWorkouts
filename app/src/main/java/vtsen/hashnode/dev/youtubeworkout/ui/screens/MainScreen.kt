package vtsen.hashnode.dev.youtubeworkout.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import vtsen.hashnode.dev.youtubeworkout.R
import vtsen.hashnode.dev.youtubeworkout.ui.theme.NewEmptyComposeAppTheme

@Composable
fun MainScreen() {
    Text(text = stringResource(id = R.string.hello_android))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewEmptyComposeAppTheme(useSystemUIController = false) {
        MainScreen()
    }
}