package no.nrk.tv.ui.preview

import no.nrk.tv.data.model.LiveItemChannelModel
import no.nrk.tv.data.model.LiveItemEventModel
import no.nrk.tv.data.model.LiveItemProgramModel
import no.nrk.tv.data.model.PlayingMetaModel
import no.nrk.tv.type.LiveType

object PreviewData {
    val liveItemChannelModel = LiveItemChannelModel(
        liveType = LiveType.channel,
        uri = "-",
        imageUrl = "",
        channelId = "NRK2",
        currentlyPlaying = PlayingMetaModel(
            time = "Nå",
            programName = "Maskorama"
        ),
        upNext = PlayingMetaModel(
            time = "19:30",
            programName = "Noe annet"
        )
    )

    val liveItemEventModel = LiveItemEventModel(
        liveType = LiveType.event,
        uri = "-",
        displayText = "Gjett hvem som skjuler seg bak masken",
        buttonText = "Fortsett"
    )

    val liveItemProgramModel = LiveItemProgramModel(
        liveType = LiveType.program,
        uri = "-",
        imageUrl = "",
        progress = 25
    )
}
