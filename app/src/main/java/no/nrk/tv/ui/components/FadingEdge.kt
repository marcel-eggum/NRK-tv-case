package no.nrk.tv.ui.components

import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun androidx.compose.ui.Modifier.fadingEdge(
    topEdgeHeight: Dp = 64.dp,
) = drawWithContent {
    drawContent()

    val bottomEndY = size.height

    drawRect(
        Brush.verticalGradient(
            colors = listOf(Color.Black, Color.Transparent),
            startY = bottomEndY - topEdgeHeight.toPx(),
            endY = bottomEndY,
        ),
        blendMode = BlendMode.DstIn,
    )
}