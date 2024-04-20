package com.beam.composecatalog

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.beam.composecatalog.ui.theme.Compose_catalogTheme

@Composable
fun MyCheckbox() {
    var state by rememberSaveable { mutableStateOf(true) }

    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.DarkGray,
            checkmarkColor = Color.Yellow,
        )
    )
}

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }

    Switch(checked = state, onCheckedChange = { state = !state })
}

@Preview(showBackground = true)
@Composable
fun SelectComponentDefaultPreview() {
    Compose_catalogTheme {
        MyCheckbox()
    }
}