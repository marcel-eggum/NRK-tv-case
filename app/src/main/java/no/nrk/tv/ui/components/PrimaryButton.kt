package no.nrk.tv.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import no.nrk.tv.ui.theme.Dimen
import no.nrk.tv.ui.theme.TvTheme

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        onClick = onClick,
    ) {
        Text(
            modifier = Modifier.padding(horizontal = Dimen.Padding.medium()),
            text = text
        )
    }
}

@Preview
@Composable
private fun PrimaryButtonPreview() {
    TvTheme {
        Surface {
            PrimaryButton(text = "Preview", onClick = {})
        }
    }
}