package no.nrk.tv.ui.direct

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import no.nrk.tv.R
import no.nrk.tv.common.Util
import no.nrk.tv.data.model.LiveItemChannelModel
import no.nrk.tv.data.model.LiveItemEventModel
import no.nrk.tv.data.model.LiveItemProgramModel
import no.nrk.tv.type.UiStateType.DEFAULT
import no.nrk.tv.type.UiStateType.ERROR
import no.nrk.tv.type.UiStateType.LOADING
import no.nrk.tv.ui.components.ErrorSegment
import no.nrk.tv.ui.components.LiveItemChannel
import no.nrk.tv.ui.components.LiveItemEvent
import no.nrk.tv.ui.components.LiveItemProgram
import no.nrk.tv.ui.components.LoadingSegment
import no.nrk.tv.ui.preview.PreviewData
import no.nrk.tv.ui.theme.Dimen
import no.nrk.tv.ui.theme.Teal
import no.nrk.tv.ui.theme.TvTheme
import org.koin.compose.koinInject

@Composable
fun DirectScreen(
    modifier: Modifier = Modifier,
    directViewModel: DirectViewModel = koinInject()
) {
    val context = LocalContext.current
    val uiState by directViewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        directViewModel.fetchFeed()
    }

    val onItemClickListener: (uri: String) -> Unit = { uri ->
        Util.openWebPage(context, uri)
            .onFailure { Util.toast(context, context.getString(R.string.error_default)) }
    }

    DirectPage(
        modifier = modifier,
        uiState = uiState,
        onItemClick = onItemClickListener
    )
}

@Composable
private fun DirectPage(
    modifier: Modifier = Modifier,
    uiState: DirectUiState,
    onItemClick: (uri: String) -> Unit
) {
    if (uiState.uiStateType == LOADING) {
        LoadingSegment()
        return
    }

    if (uiState.uiStateType == ERROR) {
        ErrorSegment()
        return
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(Dimen.Padding.medium()),
        verticalArrangement = Arrangement.spacedBy(Dimen.Padding.medium()),
    ) {
        item {
            Text(
                text = stringResource(R.string.direkte_page),
                style = MaterialTheme.typography.headlineMedium
            )
        }

        uiState.feedList.forEach { liveItem ->
            item {
                if (liveItem is LiveItemChannelModel) {
                    LiveItemChannel(
                        modifier = Modifier.clickable { onItemClick(liveItem.uri) },
                        liveItemChannelModel = liveItem
                    )
                } else if (liveItem is LiveItemEventModel) {
                    LiveItemEvent(
                        liveItemEventModel = liveItem,
                        onClick = { onItemClick(liveItem.uri) }
                    )
                } else if (liveItem is LiveItemProgramModel) {
                    LiveItemProgram(
                        modifier = Modifier.clickable { onItemClick(liveItem.uri) },
                        liveItemProgramModel = liveItem,
                    )
                }
            }
        }

        item { Spacer(modifier = Modifier.padding(Dimen.Padding.large())) }
    }
}

@Composable
@Preview
private fun DirectPagePreview() {
    TvTheme {
        Surface(color = Teal) {
            DirectPage(
                uiState = DirectUiState(
                    uiStateType = DEFAULT,
                    feedList = listOf(
                        PreviewData.liveItemChannelModel,
                        PreviewData.liveItemEventModel,
                        PreviewData.liveItemProgramModel,
                    )
                ),
                onItemClick = {}
            )
        }
    }
}

@Composable
@Preview
private fun DirectPageLoadingPreview() {
    TvTheme {
        Surface(color = Teal) {
            DirectPage(
                uiState = DirectUiState(
                    uiStateType = LOADING
                ),
                onItemClick = {}
            )
        }
    }
}

@Composable
@Preview
private fun DirectPageErrorPreview() {
    TvTheme {
        Surface(color = Teal) {
            DirectPage(
                uiState = DirectUiState(
                    uiStateType = ERROR
                ),
                onItemClick = {}
            )
        }
    }
}
