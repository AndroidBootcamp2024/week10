package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.countryinfo.R
import com.kodeco.android.countryinfo.models.Country

@Composable
fun Loading() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            ShimmerButtonAnimation()
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            item { ShimmerAnimation() }
            item { ShimmerAnimation()}
            item { ShimmerAnimation()}
            item { ShimmerAnimation()}
            item { ShimmerAnimation()}
            item { ShimmerAnimation()}
            item { ShimmerAnimation()}
            item { ShimmerAnimation()}
            item { ShimmerAnimation()}
            item { ShimmerAnimation()}
            item { ShimmerAnimation()}
        }
    }
}

@Preview
@Composable
fun LoadingPreview() {
    Loading()
}
