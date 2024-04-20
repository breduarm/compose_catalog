package com.beam.composecatalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.ToggleOff
import androidx.compose.material.icons.rounded.ToggleOn
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beam.composecatalog.ui.theme.Compose_catalogTheme

@Composable
fun MyIconSwitch() {
    var isTurnOn by rememberSaveable { mutableStateOf(true) }

    Icon(
        modifier = Modifier.clickable { isTurnOn = !isTurnOn },
        imageVector = if (isTurnOn) Icons.Rounded.ToggleOn else Icons.Rounded.ToggleOff,
        tint = if (isTurnOn) Color.Green else Color.Red,
        contentDescription = "Switch Icon made with Icon component")
}

@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Rounded.Star, contentDescription = "This is an Icon example", tint = Color.Red)
}

@Composable
fun MyImageAdvance() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Image(
            modifier = Modifier.clip(RoundedCornerShape(100f)),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "This is an image example"
        )
        MySpacer(size = 24)
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, Color.Red, CircleShape),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "This is an image example"
        )
    }
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "This is an image example",
        alpha = 0.5f
    )
}

@Preview(showBackground = true)
@Composable
fun ImageDefaultPreview() {
    Compose_catalogTheme {
        MyIconSwitch()
    }
}