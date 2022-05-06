package cz.lastaapps.cv.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import cz.lastaapps.cv.R
import cz.lastaapps.cv.Secret

@Composable
fun Title(modifier: Modifier = Modifier, secret: Secret = LocalSecretProvider.current) {
    Column(modifier) {
        Text(secret.name)
        Text(stringResource(R.string.label_sub))
    }
}
