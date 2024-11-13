package no.nrk.tv.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import no.nrk.tv.R
import no.nrk.tv.data.model.LiveItemProgramModel
import no.nrk.tv.ui.preview.PreviewData
import no.nrk.tv.ui.theme.Dimen
import no.nrk.tv.ui.theme.Shapes
import no.nrk.tv.ui.theme.SignalRed
import no.nrk.tv.ui.theme.TvTheme

@Composable
fun LiveItemProgram(
    modifier: Modifier = Modifier,
    liveItemProgramModel: LiveItemProgramModel
) {
    Box(
        modifier = modifier
            .clip(Shapes.medium)
            .height(Dimen.Item.liveItemHeight())
            .fillMaxWidth(),
        contentAlignment = Alignment.TopStart
    ) {
        LiveImage(
            Modifier.fillMaxSize(),
            data = liveItemProgramModel.imageUrl
        )

        Column(
            modifier = Modifier,
        ) {
            LiveLabel(
                modifier = Modifier.padding(Dimen.Padding.small()),
                labelText = stringResource(R.string.direkte_label)
            )

            Spacer(modifier = Modifier.weight(1.0f, true))

            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                color = SignalRed,
                trackColor = SignalRed.copy(alpha = 0.5f),
                progress = { liveItemProgramModel.progress / 100f },
            )
        }
    }
}

@Preview
@Composable
private fun LiveItemProgramPreview() {
    TvTheme {
        Surface {
            LiveItemProgram(liveItemProgramModel = PreviewData.liveItemProgramModel)
        }
    }
}