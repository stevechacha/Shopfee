package org.feeshop.shopfee.presentation.screens.onboarding


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.feeshop.shopfee.presentation.composable.ImageSliderIndicator
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingMainScreen(
    navigateBack:() -> Unit = {},
    onClickAction: () -> Unit
) {

    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerState = rememberPagerState(initialPage = 0, pageCount = {3})
    val coroutineScope = rememberCoroutineScope()
//    val isOnBoardingCompleted by onBoardViewModel.isOnBoardingCompleted().collectAsState(false)

//    val autoScrollEnabled = !isOnBoardingCompleted
    val autoScrollInterval = 5000L // Time in milliseconds between auto-scrolls

    LaunchedEffect(UInt) {
            while (true) {
                delay(autoScrollInterval)
                coroutineScope.launch {
                    val nextPage = (pagerState.currentPage + 1) % pages.size
                    pagerState.animateScrollToPage(page = nextPage)
                }
            }
    }

    val buttonState  = remember{
        derivedStateOf {
            when(pagerState.currentPage){
                0 -> listOf("","Next")
                1 -> listOf("","Next")
                2 -> listOf("","Get Started")
                else -> listOf("","")
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])

        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Box {
                ImageSliderIndicator(
                    itemCount = 3,
                    pagerState = pagerState,
                    indicatorAlignment = Alignment.BottomStart
                )
            }
            if (buttonState.value[0].isNotEmpty()) {
                OnBoardingButton(
                    text = buttonState.value[0],
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                        }
                    }
                )

            }

            OnBoardingButton(
                text = buttonState.value[1],
                onClick = {
                    coroutineScope.launch {
                        if (pagerState.currentPage == 2) {
//                            onBoardViewModel.isOnBoardingCompleted()
//                            onBoardViewModel.saveOnBoardingState(completed = true)
                            navigateBack()
                            onClickAction()

                        } else {
                            pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        TextButton(
            onClick = {},
            modifier = Modifier.align(Alignment.End)
        ){
            Text("Skip")
        }
        Image(
            painter = painterResource(onBoardingPage.image),
            contentDescription =  null,
            modifier = Modifier.fillMaxWidth(.6f).fillMaxHeight(0.6f)
        )

        Text(
            text = onBoardingPage.title.toString(),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
        )
        Text(
            text = onBoardingPage.description.toString(),
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium

        )
    }
}


@Composable
fun OnBoardingButton(
    text: String,
    onClick: () -> Unit
) {
    Box (
        modifier = Modifier.fillMaxWidth(.4f).padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ){
        TextButton(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth().height(48.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White,
            ),
            shape = RoundedCornerShape(8.dp)
        ){
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = text,
                    color = Color.White
                )
                Spacer(Modifier.width(16.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = text
                )

            }
        }

    }

}