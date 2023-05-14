package com.manicpixie.annoteappcompose.presentation.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.activity.compose.BackHandler
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, androidx.constraintlayout.compose.ExperimentalMotionApi::class)
@Composable
fun OnboardingScreen(
    screenHeight: Dp,
    onGettingStartedClick: () -> Unit
) {
    val pagerState = rememberPagerState(5)
    val coroutineScope = rememberCoroutineScope()

    // Handle system back button press
    BackHandler(enabled = pagerState.currentPage > 0) {
        coroutineScope.launch {
            pagerState.animateScrollToPage(pagerState.currentPage - 1)
        }
    }

    Box() {
        Column {
            HorizontalPager(
                count = 6,
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) { page ->
                when (page) {
                    0 -> FirstOnboardingScreen(screenHeight = screenHeight)
                    1 -> TwentyThirteenOnboardingScreen(
                        currentPage = pagerState.currentPage
                    )
                    2 -> TwentyFourteenOnboardingScreen(
                        currentPage = pagerState.currentPage
                    )
                    3 -> TwentyNineteenOnboardingScreen(
                        currentPage = pagerState.currentPage
                    )
                    4 -> TwentyTwentyOnboardingScreen(
                        currentPage = pagerState.currentPage
                    )
                    5 -> TwentyTwentyTwoOnboardingScreen(
                        screenHeight = screenHeight,
                        currentPage = pagerState.currentPage,
                        onGettingStartedClick = onGettingStartedClick
                    )
                }
            }
        }
    }
}
