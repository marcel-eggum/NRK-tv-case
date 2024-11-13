package no.nrk.tv.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import no.nrk.tv.ui.theme.Dimen
import no.nrk.tv.ui.theme.Shapes
import no.nrk.tv.ui.theme.SignalRed

@Composable
fun LiveLabel(modifier: Modifier = Modifier, labelText: String) {
    Box(
        modifier = modifier
            .clip(Shapes.medium)
            .background(SignalRed),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(
                vertical = Dimen.Padding.tiny(),
                horizontal = Dimen.Padding.tiny().times(2)
            ),
            text = labelText.uppercase(),
            style = MaterialTheme.typography.labelSmall
        )
    }
}