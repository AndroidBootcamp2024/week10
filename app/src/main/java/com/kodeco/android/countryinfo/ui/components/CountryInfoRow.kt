package com.kodeco.android.countryinfo.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.kodeco.android.countryinfo.R
import com.kodeco.android.countryinfo.models.Country
import com.kodeco.android.countryinfo.sample.sampleCountry

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryInfoRow(
    country: Country,
    onTap: () -> Unit,
    onSetAsFavorite: (Country) -> Unit,
) {
    var isExpanded by remember { mutableStateOf(false) }

    val size = remember { Animatable(48.dp.value) }

    LaunchedEffect(isExpanded) {
        if (isExpanded) {
            size.animateTo(
                targetValue = 64.dp.value,
                animationSpec = tween(durationMillis = 250)
            )
            size.animateTo(
                targetValue = 48.dp.value ,
                animationSpec = tween(durationMillis = 250)
            )
            isExpanded = false
        }
    }
    Card(
        onClick = onTap,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier
                .padding(all = 8.dp)
                .weight(8.0f)) {
                Text(text = "Name: ${country.commonName}")
                Text(text = "Capital: ${country.capital?.firstOrNull() ?: "N/A"}")
            }
            Icon(
                painter = painterResource(id = if (country.isFavorite) R.drawable.star_filled else R.drawable.star_outline),
                contentDescription = "star",
                tint = if (country.isFavorite) Color.Yellow else Color.Black,
                modifier = Modifier
                    .height(size.value.dp)
                    .width(size.value.dp)
                    .padding(10.dp)
                    .weight(2.0f)
                    .clickable(onClick = {
                        onSetAsFavorite(country)
                        isExpanded = true
                    })
            )

        }

    }
}

@Preview
@Composable
fun CountryInfoRowPreview() {
    CountryInfoRow(
        country = sampleCountry,
        onTap = {},
        onSetAsFavorite =  {
        }
    )
}
