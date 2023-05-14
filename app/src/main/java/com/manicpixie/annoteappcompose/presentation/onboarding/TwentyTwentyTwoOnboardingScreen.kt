package com.manicpixie.annoteappcompose.presentation.onboarding

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import com.manicpixie.annoteappcompose.R
import com.manicpixie.annoteappcompose.presentation.util.AppButton
import com.manicpixie.annoteappcompose.presentation.util.dpToSp
import com.manicpixie.annoteappcompose.ui.theme.PrimaryBlack
import com.manicpixie.annoteappcompose.ui.theme.White
import com.manicpixie.annoteappcompose.ui.theme.urbanistFont
import kotlinx.coroutines.delay


import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource

@ExperimentalMotionApi
@OptIn(ExperimentalAnimationApi::class, androidx.compose.material.ExperimentalMaterialApi::class)
@Composable
fun TwentyTwentyTwoOnboardingScreen(
    screenHeight: Dp,
    currentPage: Int,
    onGettingStartedClick: () -> Unit
) {
    var currentState by remember { mutableStateOf(true) }
    val transition = updateTransition(currentState, "position")
    val buttonsOffset by transition.animateDp(
        transitionSpec = {
            tween(
                durationMillis = 700
            )
        },
        label = "buttons offset"
    ) { state ->
        when (state) {
            true -> 100.dp
            false -> 0.dp
        }
    }

    LaunchedEffect(currentState) {
        delay(700)
        currentState = false
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(White)) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth(),
                text = stringResource(id = R.string.onboarding_screen_2022_text1),
                style = MaterialTheme.typography.caption,
                fontSize = dpToSp(dp = 40.dp),
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(id = R.drawable.twentytwentytwo),
                contentDescription = "Jetpack Compose Image",
                modifier = Modifier
                    .height(if (screenHeight > 600.dp) 370.dp else 250.dp)
            )
            Text(
                modifier = Modifier.padding(top = 30.dp),
                text = stringResource(id = R.string.onboarding_screen_2022_text2),
                style = TextStyle(
                    fontFamily = urbanistFont,
                    fontWeight = FontWeight.ExtraBold,
                    color = PrimaryBlack,
                    fontSize = dpToSp(26.dp),
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.onboarding_screen_2022_text3),
                style = TextStyle(
                    fontFamily = urbanistFont,
                    fontWeight = FontWeight.SemiBold,
                    color = PrimaryBlack,
                    fontSize = dpToSp(18.dp)
                )
            )

        }

        AppButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .offset(0.dp, buttonsOffset)
                .padding(start = 30.dp, end = 30.dp, bottom = 30.dp),
            text = stringResource(id = R.string.lets_go),
            fontColor = White,
            backgroundColor = PrimaryBlack,
            onClick = onGettingStartedClick
        )
    }
}
