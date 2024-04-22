package com.beam.composecatalog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beam.composecatalog.ui.theme.Compose_catalogTheme

@Composable
fun MyRangeSlider() {
    var sliderPos by remember { mutableStateOf(0f..10f) }

    Column {
        RangeSlider(
            value = sliderPos,
            valueRange = 0f..10f,
            steps = 9,
            onValueChange = { sliderPos = it },
        )
        Text(text = "Slider position = $sliderPos")
        Text(text = "Slider start position = ${sliderPos.start.toInt()}")
        Text(text = "Slider end position = ${sliderPos.endInclusive.toInt()}")
    }
}

@Composable
fun MySliderWithRange() {
    var sliderPos by rememberSaveable { mutableFloatStateOf(0f) }
    var sliderValue by rememberSaveable { mutableIntStateOf(0) }

    Column {
        Slider(
            value = sliderPos,
            valueRange = 0f..100f,
            steps = 99,
            onValueChange = { sliderPos = it },
            onValueChangeFinished = { sliderValue = sliderPos.toInt() }
        )
        Text(text = "Slider position = $sliderValue")
        Text(text = "Slider percentage = ${sliderPos.toInt()}%")
    }
}

@Composable
fun MySlider() {
    var sliderPos by rememberSaveable { mutableFloatStateOf(0f) }

    Column {
        Slider(value = sliderPos, onValueChange = { sliderPos = it })
        Text(text = "Slider position = $sliderPos")
        Text(text = "Slider percentage = ${(sliderPos).toInt()}%")
    }
}

@Preview(showBackground = true)
@Composable
fun SliderComponentsDefaultPreview() {
    Compose_catalogTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            MyRangeSlider()
        }
    }
}