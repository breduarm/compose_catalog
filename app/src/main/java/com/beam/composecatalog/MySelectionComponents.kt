package com.beam.composecatalog

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.beam.composecatalog.ui.theme.Compose_catalogTheme

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }
    
    Switch(checked = state, onCheckedChange = {state = !state})
}

@Preview(showBackground = true)
@Composable
fun SelectComponentDefaultPreview() {
    Compose_catalogTheme {
        MySwitch()
    }
}