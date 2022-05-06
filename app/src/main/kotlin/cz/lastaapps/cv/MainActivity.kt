package cz.lastaapps.cv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cz.lastaapps.cv.ui.*
import cz.lastaapps.cv.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { false }

        setContent {
            AppTheme {
                AppLayout(
                    activity = this,
                    title = { Title() },
                    main = { About() },
                    side = { Details() },
                    author = { Author(Modifier.fillMaxWidth()) },
                )
            }
        }
    }
}
