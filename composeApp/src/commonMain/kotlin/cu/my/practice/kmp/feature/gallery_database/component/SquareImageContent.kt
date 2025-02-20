package cu.my.practice.kmp.feature.gallery_database.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cu.my.practice.kmp.core.model.picture.Picture
import cu.my.practice.kmp.feature.gallery_database.style.ImageviewColors
import my_practice_kmp.composeapp.generated.resources.Res
import my_practice_kmp.composeapp.generated.resources.visibility_24dp
import org.jetbrains.compose.resources.painterResource


@Composable
fun SquareImageContent(
    picture: Picture,
    isHighlighted: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .aspectRatio(1F)
            .clickable(onClick = onClick)
    ) {
        SquareImage(
            modifier = Modifier.fillMaxSize(),
            picture = picture
        )

        val tween = tween<Float>(
            durationMillis = AnimationConstants.DefaultDurationMillis * 2,
            delayMillis = 100,
            easing = LinearOutSlowInEasing
        )

        AnimatedVisibility(visible = isHighlighted, enter = fadeIn(tween), exit = fadeOut(tween)) {
            Box(modifier = Modifier.fillMaxSize().background(ImageviewColors.uiLightBlack)) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 4.dp, bottom = 4.dp)
                        .clip(CircleShape)
                        .width(32.dp)
                        .background(ImageviewColors.uiLightBlack)
                        .aspectRatio(1F)
                        .clickable { onClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.visibility_24dp),
                        contentDescription = null,
                        modifier = Modifier.size(17.dp),
                        tint = Color.White
                    )
                }
            }
        }
    }
}
