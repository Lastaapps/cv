package cz.lastaapps.cv.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import cz.lastaapps.cv.Secret
import java.time.format.DateTimeFormatter

@Composable
fun Details(modifier: Modifier = Modifier, secret: Secret = LocalSecretProvider.current) {
    Column(modifier) {
        Born(secret)
        Contacts(secret)
        WebLinks(secret)
    }
}

@Composable
private fun Born(secret: Secret, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text("Narozen")
        Text(secret.bornWhen.format(DateTimeFormatter.ISO_LOCAL_DATE))
        Text(secret.bornWhere)
    }
}

@Composable
private fun Contacts(secret: Secret, modifier: Modifier = Modifier) {
    val uriHandler = LocalUriHandler.current
    Column(modifier) {
        Text("Kontakt")
        ClickableText(secret.email, ("mailto:${secret.email}"))
        ClickableText(secret.phoneNumber, "tel:${secret.phoneNumber}")
        Text(secret.addressHouse)
        Text(secret.addressTown)
    }
}

@Composable
private fun WebLinks(secret: Secret, modifier: Modifier = Modifier) {
    if (secret.weblinks.isEmpty()) return
    Column(modifier) {
        Text("Web Links")
        secret.weblinks.forEach {
            val url = it.second
            if (url != null)
                ClickableText(it.first, url)
            else
                Text(it.first)
        }
    }
}
