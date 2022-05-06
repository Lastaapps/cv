@file:OptIn(ExperimentalMaterial3Api::class)

package cz.lastaapps.cv.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cz.lastaapps.cv.Secret

@Composable
fun About(modifier: Modifier = Modifier, secret: Secret = LocalSecretProvider.current) {
    Box(modifier) {
        Column(
            Modifier.width(IntrinsicSize.Max),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            val childMod = Modifier.fillMaxWidth()
            AboutMe(secret, childMod)
            Education(secret, childMod)
            Projects(secret, childMod)
            Others(secret, childMod)
            Ending(secret, childMod)
        }
    }
}

@Composable
private fun AboutMe(secret: Secret, modifier: Modifier = Modifier) {
    ElevatedCard(modifier) {
        Column(Modifier.padding(12.dp)) {
            Text("O mně", style = MaterialTheme.typography.titleLarge)
            Text(secret.aboutMe)
        }
    }
}

@Composable
private fun Education(secret: Secret, modifier: Modifier = Modifier) {
    if (secret.experience.isEmpty()) return
    ElevatedCard(modifier) {
        Column(Modifier.padding(12.dp)) {
            Text("Zkušenosti", style = MaterialTheme.typography.titleLarge)
            secret.experience.forEach {
                Text(it)
            }
        }
    }
}

@Composable
private fun Projects(secret: Secret, modifier: Modifier = Modifier) {
    if (secret.projects.isEmpty()) return
    ElevatedCard(modifier) {
        Column(Modifier.padding(12.dp)) {
            Text("Projekty", style = MaterialTheme.typography.titleLarge)
            secret.projects.forEach {
                val url = it.second
                if (url != null)
                    ClickableText(it.first, url)
                else
                    Text(it.first)
            }
        }
    }
}

@Composable
private fun Others(secret: Secret, modifier: Modifier = Modifier) {
    if (secret.other.isEmpty()) return
    ElevatedCard(modifier) {
        Column(Modifier.padding(12.dp)) {
            Text("Další", style = MaterialTheme.typography.titleLarge)
            secret.other.forEach {
                Text(it)
            }
        }
    }
}

@Composable
private fun Ending(secret: Secret, modifier: Modifier = Modifier) {
    OutlinedCard(modifier) {
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(secret.ending, Modifier.padding(12.dp), textAlign = TextAlign.Center)
        }
    }
}
