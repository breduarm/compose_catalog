package com.beam.composecatalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import com.beam.composecatalog.domain.CheckInfo
import com.beam.composecatalog.ui.theme.Compose_catalogTheme

@Composable
fun MyRadioButtonWithStateHosting() {
    var selected by rememberSaveable { mutableStateOf("ChatGpt") }

    MyRadioButtonList(selected) { newSelection ->
        selected = newSelection
    }
}

@Composable
fun MyRadioButtonList(optionSelected: String, onOptionSelected: (String) -> Unit) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = optionSelected == "ChatGpt",
                onClick = { onOptionSelected("ChatGpt") }
            )
            Text(text = "ChatGpt")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = optionSelected == "Gemini",
                onClick = { onOptionSelected("Gemini") }
            )
            Text(text = "Gemini")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = optionSelected == "Bart",
                onClick = { onOptionSelected("Bart") }
            )
            Text(text = "Bart")
        }
    }
}

@Composable
fun MyRadioButton() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = true,
            enabled = false,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Green,
                unselectedColor = Color.Blue,
                disabledSelectedColor = Color.LightGray,
                disabledUnselectedColor = Color.DarkGray,
            ),
            onClick = { }
        )
        Text(text = "This is a radio button example")
    }
}

@Composable
fun MyTriStateCheckbox() {
    var state by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TriStateCheckbox(state = state, onClick = {
            state = when (state) {
                ToggleableState.On -> ToggleableState.Off
                ToggleableState.Off -> ToggleableState.Indeterminate
                ToggleableState.Indeterminate -> ToggleableState.On
            }
        })
        Text(text = "This is a tri-state Checkbox")
    }
}

@Composable
fun MyMultipleCheckbox() {
    val titles: List<String> = listOf("Checkbox 1", "Checkbox 2", "Checkbox 3")
    val options: List<CheckInfo> = titles.map { title ->
        var state by rememberSaveable { mutableStateOf(true) }
        CheckInfo(title = title, selected = state) { newState ->
            state = newState
        }
    }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        options.forEach { checkInfo ->
            MyCheckboxWithCheckInfo(checkInfo)
        }
    }
}

@Composable
fun MyCheckboxWithCheckInfo(checkInfo: CheckInfo) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        MyCheckbox(checkInfo.selected, checkInfo.onCheckedChange)
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyCheckboxWithText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        MyCheckbox()
        Text(text = "This is a checkbox")
    }
}

@Composable
fun MyCheckbox(state: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Checkbox(
        checked = state,
        onCheckedChange = onCheckedChange,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.DarkGray,
            checkmarkColor = Color.Yellow,
        )
    )
}

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
        MyRadioButtonWithStateHosting()
    }
}