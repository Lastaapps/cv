package cz.lastaapps.cv.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import cz.lastaapps.cv.BuildConfig
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable
fun Author(modifier: Modifier = Modifier) {
    Column(
        modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val uriHandler = LocalUriHandler.current
        Text(
            "Lasta Apps ${
                ZonedDateTime.ofInstant(
                    Instant.ofEpochMilli(BuildConfig.TIMESTAMP),
                    ZoneId.of("UTC")
                ).format(DateTimeFormatter.ofPattern("YYYY"))
            }"
        )
        OutlinedButton({
            uriHandler.openUri("https://github.com/Lastaapps/cv")
        }) {
            Text(text = "Zdrojový kód")
        }
    }
}