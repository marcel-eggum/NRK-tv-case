package no.nrk.tv.data.model

import no.nrk.tv.type.LiveType

abstract class LiveItemModel {
    abstract val liveType: LiveType
    abstract val uri: String
}

data class LiveItemChannelModel(
    override val liveType: LiveType,
    override val uri: String,
    val imageUrl: String,
    val channelId: String,
    val currentlyPlaying: PlayingMetaModel,
    val upNext: PlayingMetaModel,
) : LiveItemModel()

data class LiveItemProgramModel(
    override val liveType: LiveType,
    override val uri: String,
    val imageUrl: String,
    val progress: Int
) : LiveItemModel()

data class LiveItemEventModel(
    override val liveType: LiveType,
    override val uri: String,
    val displayText: String,
    val buttonText: String,
) : LiveItemModel()

data class PlayingMetaModel(
    val time: String,
    val programName: String
)