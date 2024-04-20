package com.beam.composecatalog

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beam.composecatalog.ui.theme.Compose_catalogTheme


@Composable
fun MyButton(isEnable: Boolean) {
    var enable by rememberSaveable { mutableStateOf(true) }
    enable = isEnable

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            enabled = isEnable,
            onClick = {
                Log.i("MyButton", "This is an example")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan,
                contentColor = Color.Red
            ),
            border = BorderStroke(5.dp, Color.Magenta)
        ) {
            Text(text = "Don't press this button")
        }

        OutlinedButton(
            enabled = isEnable,
            onClick = {
                Log.i("MyOutlinedButton", "This is an example")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.Magenta
            ),
        ) {
            Text(text = "Don't press this outlined button")
        }

        TextButton(onClick = {
            Log.i("MyTextButton", "This is an example")
        }) {
            Text(text = "Don't press this text button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonDefaultPreview() {
    Compose_catalogTheme {
        MyButton(isEnable = true)
    }
}