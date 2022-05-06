package cz.lastaapps.cv.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cz.lastaapps.cv.Secret

@Composable
fun About(modifier: Modifier = Modifier, secret: Secret = LocalSecretProvider.current) {
    Column(modifier) {
        AboutMe(secret)
        Education(secret)
        Projects(secret)
        Others(secret)
        Ending(secret)
    }
}

@Composable
private fun AboutMe(secret: Secret, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text("O mně")
        Text(secret.aboutMe)
    }
}

@Composable
private fun Education(secret: Secret, modifier: Modifier = Modifier) {
    if (secret.experience.isEmpty()) return
    Column(modifier) {
        Text("Zkušenosti", style = MaterialTheme.typography.headlineMedium)
        secret.experience.forEach {
            Text(it)
        }
    }
}

@Composable
private fun Projects(secret: Secret, modifier: Modifier = Modifier) {
    if (secret.projects.isEmpty()) return
    Column(modifier) {
        Text("Projekty", style = MaterialTheme.typography.headlineMedium)
        secret.projects.forEach {
            val url = it.second
            if (url != null)
                ClickableText(it.first, url)
            else
                Text(it.first)
        }
    }
}

@Composable
private fun Others(secret: Secret, modifier: Modifier = Modifier) {
    if (secret.other.isEmpty()) return
    Column(modifier) {
        Text("Další", style = MaterialTheme.typography.headlineMedium)
        secret.other.forEach {
            Text(it)
        }
    }
}

@Composable
private fun Ending(secret: Secret, modifier: Modifier = Modifier) {
    Text(secret.ending)
}
