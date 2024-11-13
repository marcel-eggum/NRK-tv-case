package no.nrk.tv.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import no.nrk.tv.data.model.LiveItemEventModel
import no.nrk.tv.ui.preview.PreviewData
import no.nrk.tv.ui.theme.Dimen
import no.nrk.tv.ui.theme.Shapes
import no.nrk.tv.ui.theme.TealDarker
import no.nrk.tv.ui.theme.TvTheme

@Composable
fun LiveItemEvent(
    modifier: Modifier = Modifier,
    liveItemEventModel: LiveItemEventModel,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(Shapes.medium)
            .background(TealDarker)
            .fillMaxWidth(),
    ) {
        Column(
            modifier.padding(Dimen.Padding.large()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(horizontal = Dimen.Padding.large()),
                textAlign = TextAlign.Center,
                text = liveItemEventModel.displayText,
                style = MaterialTheme.typography.titleLarge
            )

            PrimaryButton(
                modifier = Modifier.padding(top = Dimen.Padding.medium()),
                onClick = onClick,
                text = liveItemEventModel.buttonText
            )
        }
    }
}

@Preview
@Composable
private fun LiveItemEventPreview() {
    TvTheme {
        Surface {
            LiveItemEvent(
                modifier = Modifier.fillMaxWidth(),
                liveItemEventModel = PreviewData.liveItemEventModel,
                onClick = {}
            )
        }
    }
}