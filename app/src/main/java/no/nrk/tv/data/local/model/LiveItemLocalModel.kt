package no.nrk.tv.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import no.nrk.tv.type.LiveType

@Entity(tableName = "liveitem")
data class LiveItemLocalModel (
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    val liveType: LiveType,
    val uri: String,
    val imageUrl: String?,
    val channelId: String?,
    @Embedded(prefix = "currently_")
    val currentlyPlaying: PlayingMetaLocalModel?,
    @Embedded(prefix = "upnext_")
    val upNext: PlayingMetaLocalModel?,
    val progress: Int?,
    val displayText: String?,
    val buttonText: String?,
)

data class PlayingMetaLocalModel(
    val time: String,
    val programName: String
)