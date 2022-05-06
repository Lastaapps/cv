package cz.lastaapps.cv.ui

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppLayout(
    activity: Activity,
    main: @Composable () -> Unit,
    side: @Composable () -> Unit,
) {
    WithLocalWindowSizes(activity) {
        Surface {
            if (LocalWindowWidth.current == WindowSizeClass.COMPACT) {
                Column(Modifier.fillMaxSize()) {
                    main()
                    side()
                }
            } else {
                Row(Modifier.fillMaxSize()) {
                    Box(Modifier.weight(.7f)) {
                        main()
                    }
                    Box(Modifier.weight(.3f)) {
                        side()
                    }
                }
            }
        }
    }
}