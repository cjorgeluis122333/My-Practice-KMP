package cu.my.practice.kmp.feature.gallery_database

import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cu.my.practice.kmp.core.model.picture.Picture
import cu.my.practice.kmp.feature.gallery_database.component.SquareImageContent
import cu.my.practice.kmp.feature.gallery_database.gallery.GalleryManager
import cu.my.practice.kmp.feature.gallery_database.gallery.rememberGalleryManager
import cu.my.practice.kmp.feature.gallery_database.state.GalleryEventState
import cu.my.practice.kmp.feature.gallery_database.style.ImageviewColors
import cu.my.practice.kmp.feature.gallery_database.util.animatePageChanges
import kotlinx.coroutines.launch
import my_practice_kmp.composeapp.generated.resources.Res
import my_practice_kmp.composeapp.generated.resources.upload_new_image
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GalleryScreen(viewModel: GalleryViewModel = koinViewModel(), modifier: Modifier = Modifier) {

    //All pictures save in database
    val state by viewModel.state.collectAsStateWithLifecycle()
    //The image you show
    val pictures: SnapshotStateList<Picture> = remember { mutableStateListOf() }
    //Have the control of the pictures: the current page, quantity pages, exc
    val pagerState = rememberPagerState(pageCount = { pictures.size })
    val viewScope = rememberCoroutineScope()
    //Get initial pictures
    LaunchedEffect(state.pictures) {
        if (state.pictures.isNotEmpty()) {
            pictures += state.pictures
        }
    }


    val galleryManager: GalleryManager = rememberGalleryManager { file ->
        pictures.add(0, Picture(file?.toImageBitmap()))
        viewModel.onEvent(GalleryEventState.OnInsert(Picture(file?.toImageBitmap()))) //Insert image in database
        viewScope.launch {
            pagerState.scrollToPage(0)
        }
    }

    //Take the image selected and nav to here
    fun selectPicture(index: Int) {
        viewScope.launch {
            pagerState.animateScrollToPage(
                page = index,  //Index of
                animationSpec = tween(
                    easing = LinearOutSlowInEasing,
                    durationMillis = AnimationConstants.DefaultDurationMillis * 3
                )
            )
        }
    }

    // ======================================== Main Picture
    Column(modifier = modifier.background(MaterialTheme.colorScheme.background)) {

        MainPicture(pagerState = pagerState, pictures = pictures, modifier = modifier)

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            if (pictures.isEmpty()) {
                Text(
                    text = stringResource(Res.string.upload_new_image),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyVerticalGrid(
                    modifier = Modifier.padding(top = 2.dp),
                    columns = GridCells.Adaptive(minSize = 130.dp),
                    verticalArrangement = Arrangement.spacedBy(1.dp),
                    horizontalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    itemsIndexed(pictures) { index, picture ->
                        SquareImageContent(
                            picture = picture,
                            onClick = { selectPicture(index) },
                            isHighlighted = pagerState.targetPage == index
                        )
                    }
                }
            }

            CircularButton(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(36.dp),
                onClick = { galleryManager.launch() }
            )
        }
    }
}

@Composable
fun MainPicture(pagerState: PagerState, pictures: List<Picture>, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(393.dp)
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = modifier.fillMaxSize()) {
            HorizontalPager(state = pagerState) { index ->
                val picture = pictures[index]
                var image: ImageBitmap? by remember(picture) { mutableStateOf(null) }

                LaunchedEffect(picture) { image = picture.imageBitmap }

                image?.let {
                    Box(
                        modifier = modifier
                            .fillMaxSize()
                            .animatePageChanges(pagerState, index)
                    ) {
                        Image(
                            bitmap = it,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }


}

@Composable
fun CircularButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .size(60.dp)
            .clip(CircleShape)
            .background(ImageviewColors.uiLightBlack)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(34.dp),
            tint = Color.White,
            imageVector = Icons.Filled.Add,
            contentDescription = null
        )
    }
}
