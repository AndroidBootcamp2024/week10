package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.kodeco.android.countryinfo.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navigateToNextScreen: () -> Unit
) {
    val context = LocalContext.current
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.world)
    )
    LaunchedEffect(true) {
        delay(5000)
        navigateToNextScreen()
    }

    LottieAnimation(
        composition = composition,
        modifier = Modifier.fillMaxSize(),
        iterations = LottieConstants.IterateForever,
    )
}