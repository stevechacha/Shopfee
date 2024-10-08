package org.feeshop.shopfee.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.seiko.imageloader.AsyncImagePainter
import com.seiko.imageloader.ImageRequestState
import com.seiko.imageloader.rememberAsyncImagePainter
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun SpImageLoader(
    imageUrl: String,
    errorPlaceholderImageUrl: DrawableResource,
    modifier: Modifier = Modifier,
    showLoadingState: Boolean = true,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
    placeHolderScale: ContentScale = ContentScale.Crop,
    painter: AsyncImagePainter = rememberAsyncImagePainter(imageUrl),
) {

    when (painter.requestState) {
        is ImageRequestState.Loading,
            /*  ->{
                 AnimatedVisibility(showLoadingState) {
                     Box(modifier.fillMaxSize().clip(RoundedCornerShape(4.dp)).shimmerEffect())
                 }
             }*/

        is ImageRequestState.Failure -> {
            Image(
                modifier = modifier.fillMaxSize(),
                painter = painterResource(errorPlaceholderImageUrl),
                contentScale = placeHolderScale,
                contentDescription = contentDescription,
            )
        }

        is ImageRequestState.Success -> {
            Image(
                modifier = modifier.fillMaxSize(),
                painter = painter,
                contentScale = contentScale,
                contentDescription = contentDescription,
            )
        }
    }
}