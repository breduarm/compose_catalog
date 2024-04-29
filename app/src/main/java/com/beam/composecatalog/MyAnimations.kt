package com.beam.composecatalog

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beam.composecatalog.ui.theme.Compose_catalogTheme

@Composable
fun MyAdvanceVisibilityAnimation() {
    var showBox by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { showBox = !showBox }) {
            Text(text = "Show / Hidde")
        }
        Spacer(modifier = Modifier.size(50.dp))
        AnimatedVisibility(
            visible = showBox,
            label = "This an example of Visibility animation",
            enter = slideInHorizontally(),
            exit = slideOutHorizontally(),
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Green)
            )
        }
    }
}

@Composable
fun MyBasicVisibilityAnimation() {
    var showBox by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { showBox = !showBox }) {
            Text(text = "Show / Hidde")
        }
        Spacer(modifier = Modifier.size(50.dp))
        AnimatedVisibility(visible = showBox) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Green)
            )
        }
    }
}

@Composable
fun MyAdvanceSizeAnimation() {
    var showSmall by rememberSaveable { mutableStateOf(true) }
    var showBox by rememberSaveable { mutableStateOf(true) }
    val size by animateDpAsState(
        targetValue = if (showSmall) 50.dp else 100.dp,
        label = "This is an basic example of Size animation",
        animationSpec = tween(durationMillis = 2000),
        finishedListener = { showBox = false }
    )
    if (showBox) {
        Box(modifier = Modifier
            .size(size)
            .background(Color.Cyan)
            .clickable { showSmall = !showSmall }
        )
    }
}

@Composable
fun MyBasicSizeAnimation() {
    var showSmall by rememberSaveable { mutableStateOf(true) }
    val size by animateDpAsState(
        targetValue = if (showSmall) 50.dp else 100.dp,
        label = "This is an basic example of Size animation"
    )
    Box(modifier = Modifier
        .size(size)
        .background(Color.Cyan)
        .clickable { showSmall = !showSmall }
    )
}

@Composable
fun MyAdvanceColorAnimation() {
    var showPrimaryColor by rememberSaveable { mutableStateOf(false) }
    var showBox by rememberSaveable { mutableStateOf(true) }
    val bgColor by animateColorAsState(
        targetValue = if (showPrimaryColor) Color.Red else Color.Yellow,
        label = "This is an example of Color animation",
        animationSpec = tween(durationMillis = 2000),
        finishedListener = { showBox = false }
    )
    if (showBox) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(bgColor)
                .clickable { showPrimaryColor = !showPrimaryColor }
        )
    }
}

@Composable
fun MyBasicColorAnimation() {
    Column {
        var firstColor by rememberSaveable { mutableStateOf(false) }
        val realColor = if (firstColor) Color.Red else Color.Yellow
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor)
                .clickable { firstColor = !firstColor })
        Spacer(modifier = Modifier.size(200.dp))
        var secondColor by rememberSaveable { mutableStateOf(false) }
        val secondRealColor by animateColorAsState(
            targetValue = if (secondColor) Color.Red else Color.Yellow,
            label = "This is a label"
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(secondRealColor)
                .clickable { secondColor = !secondColor })
    }
}

@Preview(showBackground = true)
@Composable
fun AnimationsDefaultPreview() {
    Compose_catalogTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            MyAdvanceVisibilityAnimation()
        }
    }
}