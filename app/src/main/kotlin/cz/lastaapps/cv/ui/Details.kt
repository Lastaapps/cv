@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package cz.lastaapps.cv.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.lastaapps.cv.Secret
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun Details(modifier: Modifier = Modifier, secret: Secret = LocalSecretProvider.current) {
    Column(
        modifier, verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        val childMod = Modifier.fillMaxWidth()
        Born(secret, childMod)
        Contacts(secret, childMod)
        WebLinks(secret, childMod)
    }
}

@Composable
private fun Born(secret: Secret, modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
    ) {
        Column(Modifier.padding(12.dp)) {
            Text("Narozen", style = MaterialTheme.typography.titleLarge)
            Text(secret.bornWhen.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)))
            Text(secret.bornWhere)
        }
    }
}

@Composable
private fun Contacts(secret: Secret, modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
    ) {
        Column(Modifier.padding(12.dp)) {
            Text("Kontakt", style = MaterialTheme.typography.titleLarge)
            ClickableText(secret.email, ("mailto:${secret.email}"))
            ClickableText(secret.phoneNumber, "tel:${secret.phoneNumber}")
            Text(secret.addressHouse)
            Text(secret.addressTown)
        }
    }
}

@Composable
private fun WebLinks(secret: Secret, modifier: Modifier = Modifier) {
    if (secret.weblinks.isEmpty()) return
    ElevatedCard(
        modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
    ) {
        Column(Modifier.padding(12.dp)) {
            Text("Web Links", style = MaterialTheme.typography.titleLarge)
            secret.weblinks.forEach {
                val url = it.second
                if (url != null)
                    ClickableText(it.first, url)
                else
                    Text(it.first)
            }
        }
    }
}
