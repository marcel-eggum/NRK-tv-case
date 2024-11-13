package no.nrk.tv.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import no.nrk.tv.ui.theme.Dimen
import no.nrk.tv.ui.theme.TvTheme

@Composable
fun LiveImage(
    modifier: Modifier = Modifier,
    data: Any?
) {
    AsyncImage(
        modifier = modifier.fadingEdge(),
        model = ImageRequest.Builder(LocalContext.current)
            .data(data)
            .crossfade(true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
private fun LiveImagePreview() {
    TvTheme {
        LiveImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen.Item.liveItemHeight()),
            data = "http://test"
        )
    }
}