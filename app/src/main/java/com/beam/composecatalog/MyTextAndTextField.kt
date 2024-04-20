package com.beam.composecatalog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beam.composecatalog.ui.theme.Compose_catalogTheme

@Composable
fun MyStateHosting() {
    var entryText by remember { mutableStateOf("Default text") }
    MyTextFieldStateHosting(entryText = entryText) {
        entryText = it
    }
}

@Composable
fun MyTextFieldStateHosting(entryText: String, onValueChange: (String) -> Unit) {
    TextField(value = entryText, onValueChange = onValueChange)
}

@Composable
fun MyTextFieldOutlined() {
    var entryText by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        OutlinedTextField(
            modifier = Modifier.padding(24.dp),
            value = entryText,
            onValueChange = { entryText = it },
            label = {
                Text(text = "Enter your text here")
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Magenta,
                unfocusedBorderColor = Color.Cyan,
            )
        )
    }
}

@Composable
fun MyTextFieldAdvance() {
    var entryText by remember { mutableStateOf("") }
    TextField(value = entryText, onValueChange = {
        entryText = if (it.contains("a")) {
            it.replace("a", "")
        } else {
            it
        }
    }, label = {
        Text(text = "Enter your text")
    })
}

@Composable
fun MyTextField() {
    var entryText by remember { mutableStateOf("Default text") }
    TextField(value = entryText, onValueChange = { entryText = it })
}

@Composable
fun MyText() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "This is a very simple text")
        Text(text = "This a text with color", color = Color.Magenta)
        Text(text = "This a text with fontWeight", fontWeight = FontWeight.Bold)
        Text(text = "This a text with fontFamily cursive", fontFamily = FontFamily.Cursive)
        Text(
            text = "This a text with textDecoration line through",
            textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = "This a text with textDecoration under line",
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = "This a text with textDecoration line through and under line",
            textDecoration = TextDecoration.combine(
                listOf(TextDecoration.LineThrough, TextDecoration.Underline)
            )
        )
        Text(text = "This is a text with font size", fontSize = 30.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun TextDefaultPreview() {
    Compose_catalogTheme {
        MyStateHosting()
    }
}