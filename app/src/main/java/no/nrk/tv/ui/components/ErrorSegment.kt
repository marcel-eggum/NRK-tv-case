package no.nrk.tv.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import no.nrk.tv.R
import no.nrk.tv.ui.theme.Dimen
import no.nrk.tv.ui.theme.TvTheme

@Composable
fun ErrorSegment(modifier: Modifier = Modifier.fillMaxSize()) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "; (", style = MaterialTheme.typography.headlineLarge)
            Text(text = stringResource(R.string.error_default))
        }
    }
}

@Preview
@Composable
private fun ErrorSegmentSegment() {
    TvTheme {
        ErrorSegment()
    }
}