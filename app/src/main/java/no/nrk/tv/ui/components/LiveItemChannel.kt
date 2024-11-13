package no.nrk.tv.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import no.nrk.tv.R
import no.nrk.tv.data.model.LiveItemChannelModel
import no.nrk.tv.data.model.PlayingMetaModel
import no.nrk.tv.type.ChannelType
import no.nrk.tv.ui.preview.PreviewData
import no.nrk.tv.ui.theme.Dimen
import no.nrk.tv.ui.theme.Shapes
import no.nrk.tv.ui.theme.TvTheme
import no.nrk.tv.ui.theme.White
import no.nrk.tv.ui.theme.White70

@Composable
fun LiveItemChannel(
    modifier: Modifier = Modifier,
    liveItemChannelModel: LiveItemChannelModel
) {
    Box(
        modifier = modifier
            .clip(Shapes.medium)
            .height(Dimen.Item.liveItemHeight())
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        LiveImage(
            Modifier.fillMaxSize(),
            data = liveItemChannelModel.imageUrl
        )

        Column(
            modifier = Modifier,
        ) {
            Spacer(modifier = Modifier.weight(1.0f, true))

            ChannelLogoImage(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = Dimen.Padding.medium()),
                channelId = liveItemChannelModel.channelId
            )

            Spacer(modifier = Modifier.weight(1.0f, true))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = Dimen.Padding.medium(),
                        end = Dimen.Padding.medium(),
                        bottom = Dimen.Padding.medium()
                    ),
                verticalArrangement = Arrangement.spacedBy(Dimen.Padding.smaller())
            ) {
                PlayingMetaItem(playingMetaModel = liveItemChannelModel.currentlyPlaying)
                PlayingMetaItem(playingMetaModel = liveItemChannelModel.upNext, fade = true)
            }
        }
    }
}

@Composable
fun ChannelLogoImage(modifier: Modifier = Modifier, channelId: String) {
    val logoResource = when (ChannelType.from(channelId)) {
        ChannelType.NRK1 -> R.drawable.logo_nrk1
        ChannelType.NRK2 -> R.drawable.logo_nrk2
        ChannelType.NRK3 -> R.drawable.logo_nrk3
        ChannelType.UNKNOWN -> R.drawable.logo_unknown
    }

    Image(
        painterResource(logoResource),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Composable
private fun PlayingMetaItem(
    playingMetaModel: PlayingMetaModel,
    fade: Boolean = false
) {
    val color = if (!fade) White else White70

    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            modifier = Modifier.width(75.dp),
            text = playingMetaModel.time,
            style = MaterialTheme.typography.titleLarge,
            color = color
        )
        Text(
            text = playingMetaModel.programName,
            style = MaterialTheme.typography.titleLarge,
            color = color
        )
    }
}

@Preview
@Composable
private fun LiveItemChannelPreview() {
    TvTheme {
        LiveItemChannel(liveItemChannelModel = PreviewData.liveItemChannelModel)
    }
}