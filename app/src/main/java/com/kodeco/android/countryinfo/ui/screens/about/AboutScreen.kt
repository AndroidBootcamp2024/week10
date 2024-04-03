package com.kodeco.android.countryinfo.ui.screens.about

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kodeco.android.countryinfo.BuildConfig
import com.kodeco.android.countryinfo.R
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme

@Composable
fun AboutScreen(
    onNavigateUp: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.about_screen_title))
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onNavigateUp()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.nav_back_content_description),
                        )
                    }
                }
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Text(
                text = stringResource(id = R.string.about_screen_content),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
            )

            AnimatedText(
                text = stringResource(id = R.string.about_screen_version, BuildConfig.VERSION_NAME),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun AnimatedText(text: String, style: TextStyle, textAlign: TextAlign) {
    var isTextShown by remember { mutableStateOf(false) }

    val textSize = remember { Animatable(0f) }

    LaunchedEffect(isTextShown) {
        textSize.animateTo(
            targetValue = if (isTextShown) 32.sp.value else 0f,
            animationSpec = tween(durationMillis = 1000)
        )
    }
    Text(
        text,
        style = style,
        textAlign = textAlign,
        fontSize = textSize.value.sp,
        color = Color.Black,
        modifier = Modifier.padding(16.dp)
    )
    LaunchedEffect(Unit) {
        isTextShown = true
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun AboutScreenPreview() {
    MyApplicationTheme {
        AboutScreen { }
    }
}
