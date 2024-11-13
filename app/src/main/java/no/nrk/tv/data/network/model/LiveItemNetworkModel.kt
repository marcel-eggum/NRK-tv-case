package no.nrk.tv.data.network.model

import no.nrk.tv.type.LiveType

data class LiveItemNetworkModel(
    val liveType: LiveType,
    val uri: String,
    val imageUrl: String?,
    val channelId: String?,
    val currentlyPlaying: PlayingMetaNetworkModel?,
    val upNext: PlayingMetaNetworkModel?,
    val progress: Int?,
    val displayText: String?,
    val buttonText: String?,
)

data class PlayingMetaNetworkModel(
    val time: String,
    val programName: String
)