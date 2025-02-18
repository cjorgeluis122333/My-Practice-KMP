package cu.my.practice.kmp.feature.gallery_database.util

import androidx.compose.foundation.pager.PagerState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import kotlin.math.absoluteValue


fun Modifier.animatePageChanges(pagerState: PagerState, index: Int) = graphicsLayer {
    val x = (pagerState.currentPage - index + pagerState.currentPageOffsetFraction)
    alpha = 1F - (x.absoluteValue * 0.7F).coerceIn(0F, 0.7F)
    val scale = 1F - (x.absoluteValue * 0.4F).coerceIn(0F, 0.4F)
    scaleX = scale
    scaleY = scale
    rotationY = x * 15F
}