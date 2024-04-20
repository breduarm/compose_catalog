package com.beam.composecatalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beam.composecatalog.ui.theme.Compose_catalogTheme
import kotlinx.coroutines.delay

@Composable
fun MyProgressBarAdvance() {
    var progress by rememberSaveable { mutableFloatStateOf(0.5f) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Red,
            trackColor = Color.Blue
        )
        MySpacer(size = 16)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { progress -= 0.1f }) {
                Text(text = "Decrement")
            }
            Button(onClick = { progress += 0.1f }) {
                Text(text = "Increase")
            }
        }
    }
}

@Composable
fun MyProgressBarStopAndContinue() {
    var isPaused by rememberSaveable { mutableStateOf(false) }
    var progress by rememberSaveable { mutableFloatStateOf(0.0f) }

    LaunchedEffect(Unit) {
        while (true) {
            if (isPaused) {
                delay(100)
            } else {
                progress = (progress + 0.01f) % 1f
                delay(50)
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Blue, strokeWidth = 5.dp, progress = progress)
        MySpacer(size = 16)
        Button(onClick = { isPaused = !isPaused }) {
            Text(text = if (isPaused) "Continue loading" else "Pause loading")
        }
    }
}

@Composable
fun MyProgressBar() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            color = Color.Red,
            trackColor = Color.Blue
        )
        MySpacer(size = 12)
        CircularProgressIndicator(color = Color.Green, strokeWidth = 10.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressBarDefaultPreview() {
    Compose_catalogTheme {
        MyProgressBarAdvance()
    }
}