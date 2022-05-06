package cz.lastaapps.cv.ui

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppLayout(
    activity: Activity,
    title: @Composable () -> Unit,
    main: @Composable () -> Unit,
    side: @Composable () -> Unit,
    author: @Composable () -> Unit,
) {
    WithLocalWindowSizes(activity) {
        Surface {
            Box(Modifier.padding(16.dp)) {
                AppContent(title, main, side, author)
            }
        }
    }
}

@Composable
private fun AppContent(
    title: @Composable () -> Unit,
    main: @Composable () -> Unit,
    side: @Composable () -> Unit,
    author: @Composable () -> Unit,
) {
    if (LocalWindowWidth.current == WindowSizeClass.COMPACT) {
        Column(
            Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            title()
            main()
            side()
            author()
        }
    } else {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Title()
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(Modifier.weight(.6f)) { main() }
                Box(
                    Modifier
                        .weight(.4f)
                        .fillMaxWidth()
                ) { side() }
            }
            author()
        }
    }
}