package cz.lastaapps.cv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cz.lastaapps.cv.ui.About
import cz.lastaapps.cv.ui.AppLayout
import cz.lastaapps.cv.ui.Details
import cz.lastaapps.cv.ui.Title
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
                    main = {
                        Column() {
                            Title()
                            About()
                        }
                    },
                    side = {
                        Details()
                    },
                )
            }
        }
    }
}
