package com.kodeco.android.countryinfo.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kodeco.android.countryinfo.models.Country
import com.kodeco.android.countryinfo.sample.sampleCountry
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay

@Composable
fun CountryDetails(
    country: Country,
    modifier: Modifier,
) {
    LazyColumn(modifier = modifier) {
        item { Text(text = "Capital: ${country.mainCapital}") }
        item { Text(text = "Population: ${country.population}") }
        item { Text(text = "Area: ${country.area}") }
        item {
            AnimatedAsyncImage(imageUrl = country.flagUrl, originalSize = 70.dp, doubleSize = 150.dp)
        }
    }
}

@Composable
fun AnimatedAsyncImage(
    imageUrl: String,
    originalSize: Dp,
    doubleSize: Dp,
    loadingColor: Color = Color.Gray
) {
    var isLoading by remember { mutableStateOf(true) }
    LaunchedEffect(imageUrl) {
        delay(2000)
        isLoading = false
    }

    val targetSize = if (isLoading) originalSize else doubleSize

    val animatedSize by animateDpAsState(
        targetValue = targetSize,
        animationSpec = tween(durationMillis = 2000)
    )

    Box(
        modifier = Modifier
            .size(animatedSize)
    ) {
        if (isLoading) {
            CircularProgressIndicator(color = loadingColor)
        } else {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Flag",
                contentScale = ContentScale.Fit,
                modifier = Modifier.border(2.dp, color = MaterialTheme.colorScheme.primary).size(doubleSize),
            )
        }
    }
}

@Preview
@Composable
fun CountryDetailsPreview() {
    MyApplicationTheme {
        CountryDetails(
            country = sampleCountry,
            modifier = Modifier,
        )
    }
}
