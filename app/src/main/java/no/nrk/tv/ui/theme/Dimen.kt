package no.nrk.tv.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Dimen {

    object Padding {
        @Composable
        fun large(): Dp {
            return 24.dp
        }

        @Composable
        fun mediumLarge(): Dp {
            return 20.dp
        }

        @Composable
        fun medium(): Dp {
            return 18.dp
        }

        @Composable
        fun small(): Dp {
            return 12.dp
        }

        @Composable
        fun smaller(): Dp {
            return 8.dp
        }

        @Composable
        fun tiny(): Dp {
            return 4.dp
        }
    }

    object Item {
        @Composable
        fun liveItemHeight(): Dp {
            return 212.dp
        }
    }

}