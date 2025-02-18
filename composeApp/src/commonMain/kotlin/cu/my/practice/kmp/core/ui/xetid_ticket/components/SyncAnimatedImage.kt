package cu.my.practice.kmp.core.ui.xetid_ticket.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import my_practice_kmp.composeapp.generated.resources.Res
import my_practice_kmp.composeapp.generated.resources.link_account
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SyncAnimatedImage(
    waiting: Boolean? = true,
    waitingSweepAngle: Float = 0f,
    arcsNumber: Int = 4,
    maxArcsDraw: Float = 360f,
    minArcsDraw: Float = 0f,
    sweepTimeDefault: Int = 1000,
    sweepTimeEnd: Int = 6000,
    arcsColorDefault: Color = MaterialTheme.colorScheme.outline,
    arcsColorEnd: Color? = MaterialTheme.colorScheme.primary,
    arcsWidth: Float = 20f,
    onEndEvent: () -> Unit = {},
    content: @Composable (RowScope.() -> Unit)
) {

    var arcsPosition: Float by remember { mutableFloatStateOf(minArcsDraw) }
    var sweepAngle: Float by remember { mutableFloatStateOf(0f) }
    var sweepTime: Int by remember { mutableIntStateOf(sweepTimeDefault) }
    var arcsColor: Color by remember { mutableStateOf(arcsColorDefault) }

    //animated vals
    val animateSweepAngle: Float by animateFloatAsState(// Animated size of the arcs
        targetValue = sweepAngle, animationSpec = tween(
            durationMillis = sweepTime, easing = FastOutSlowInEasing
        ), finishedListener = {
            if (it == (maxArcsDraw - minArcsDraw)) {
                onEndEvent()
            }
        }, label = "The arcs size"
    )
    val animateArcPosition: Float by animateFloatAsState(// Animated position of the arcs
        targetValue = arcsPosition, animationSpec = tween(
            durationMillis = sweepTime, easing = FastOutSlowInEasing
        ), label = "Bottom animated arc", finishedListener = {
            if (sweepAngle == waitingSweepAngle) {//Waiting animation
                when (it) {
                    maxArcsDraw - sweepAngle -> arcsPosition = minArcsDraw
                    minArcsDraw -> arcsPosition = maxArcsDraw - sweepAngle
                }
            }
        })
    // Animated color of arcs
    val colorLoading: Color by animateColorAsState(
        targetValue = arcsColor,
        animationSpec = tween(
            durationMillis = sweepTime, easing = FastOutSlowInEasing
        ),
        label = "loading color",
    )

    LaunchedEffect(waiting) {
        when (waiting) {
            false -> {
                sweepTime = sweepTimeDefault
                sweepAngle = 0f
                arcsPosition = minArcsDraw
                arcsColor = arcsColorDefault

                delay(sweepTimeDefault.plus(100L))//wait for the angle go to 0
                sweepAngle = 1f
                sweepTime = sweepTimeEnd
                sweepAngle = maxArcsDraw - minArcsDraw
                arcsColor = arcsColorEnd ?: arcsColorDefault
            }

            true -> {
                sweepTime = sweepTimeDefault
                sweepAngle = waitingSweepAngle
                arcsPosition = maxArcsDraw - sweepAngle
                arcsColor = arcsColorDefault
            }

            null -> {
                sweepTime = sweepTimeDefault
                sweepAngle = 0f//waitingSweepAngle
                arcsPosition = minArcsDraw
                arcsColor = arcsColorDefault

                delay(sweepTimeDefault.plus(100L))//wait for the angle go to 0
                sweepAngle = 0f
            }
        }
    }

    Box(
        contentAlignment = Alignment.Center, modifier = Modifier.aspectRatio(1f)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp)
        ) {
            Surface(
                modifier = Modifier,
            ) {
                Canvas(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxSize()
                        .padding(arcsWidth.div(2).dp)
                ) {
                    for (i in 0 until arcsNumber) {
                        drawArc(
                            color = colorLoading,
                            startAngle = animateArcPosition + 360f.div(arcsNumber).times(i),
                            sweepAngle = animateSweepAngle,
                            useCenter = false,
                            size = this.size,
                            style = Stroke(
                                width = arcsWidth, cap = StrokeCap.Round
                            )
                        )
                    }

//                    drawArc(
//                        color = colorLoading,
//                        startAngle = animateArcPosition + 180f,
//                        sweepAngle = animateSweepAngle,
//                        useCenter = false,
//                        size = this.size,
//                        style = Stroke(
//                            width = arcsWidth, cap = StrokeCap.Round
//                        )
//                    )
                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun SyncAnimatedImagePreview() {
    SyncAnimatedImage(
        waiting = true,
        maxArcsDraw = 180f,
        minArcsDraw = 0f,
        waitingSweepAngle = 45f,
    ) {
//        Image(
//            painter = painterResource(id = R.drawable.ticket_icon),
//            contentDescription = "Left icon",
//            modifier = Modifier
//                .size(100.dp)
//                .weight(1f),
//            contentScale = ContentScale.None,
//            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
//        )
        Text(
            text = stringResource(Res.string.link_account) + 's',
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f),
        )
//        Image(
//            painter = painterResource(id = R.drawable.ic_round_enzona),
//            contentDescription = "Right icon",
//            modifier = Modifier
//                .padding(25.dp)
//                .size(50.dp)
//                .weight(1f),
//            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
//        )
    }
}
