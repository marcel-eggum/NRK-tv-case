package no.nrk.tv.data

import no.nrk.tv.data.local.model.LiveItemLocalModel
import no.nrk.tv.data.local.model.PlayingMetaLocalModel
import no.nrk.tv.data.model.LiveItemChannelModel
import no.nrk.tv.data.model.LiveItemEventModel
import no.nrk.tv.data.model.LiveItemModel
import no.nrk.tv.data.model.LiveItemProgramModel
import no.nrk.tv.data.model.PlayingMetaModel
import no.nrk.tv.data.network.model.LiveItemNetworkModel
import no.nrk.tv.type.LiveType

fun LiveItemNetworkModel.asLocalModel(): LiveItemLocalModel {
    return LiveItemLocalModel(
        liveType = liveType,
        uri = uri,
        imageUrl = imageUrl,
        channelId = channelId,
        currentlyPlaying = PlayingMetaLocalModel(
            currentlyPlaying?.time ?: "",
            currentlyPlaying?.programName ?: ""
        ),
        upNext = PlayingMetaLocalModel(
            upNext?.time ?: "",
            upNext?.programName ?: ""
        ),
        progress = progress,
        displayText = displayText,
        buttonText = buttonText,
    )
}

fun LiveItemLocalModel.asExternalModel(): LiveItemModel {
    return when(liveType) {
        LiveType.channel -> {
            LiveItemChannelModel(
                liveType = liveType,
                uri = uri,
                imageUrl = imageUrl ?: "",
                channelId = channelId ?: "",
                currentlyPlaying = PlayingMetaModel(
                    time = currentlyPlaying?.time ?: "",
                    programName = currentlyPlaying?.programName ?: ""
                ),
                upNext = PlayingMetaModel(
                    time = upNext?.time ?: "",
                    programName = upNext?.programName ?: ""
                )
            )
        }
        LiveType.event -> {
            LiveItemEventModel(
                liveType = liveType,
                uri = uri,
                displayText = displayText ?: "",
                buttonText = buttonText ?: ""
            )
        }
        LiveType.program -> {
            LiveItemProgramModel(
                liveType = liveType,
                uri = uri,
                imageUrl = imageUrl ?: "",
                progress = progress ?: 0
            )
        }
    }
}