package com.beam.composecatalog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
fun MyDropdownMenu() {
    var optionSelected by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val desserts = listOf("Ice Cream", "Cheese Cake", "Tiramisu", "Brownie")

    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true },
            value = optionSelected,
            onValueChange = { optionSelected = it },
            enabled = false,
            readOnly = true
        )
        DropdownMenu(
            modifier = Modifier.fillMaxWidth(),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(
                    text = {
                        Text(text = dessert)
                    },
                    onClick = {
                        expanded = false
                        optionSelected = dessert
                    }
                )
            }
        }
    }
}

@Composable
fun MyDivider() {
    Divider(modifier = Modifier.fillMaxWidth(), color = Color.Red)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    BadgedBox(
        badge = {
            Badge(
                content = {
                    Text(text = "500+")
                },
                containerColor = Color.Red,
                contentColor = Color.Yellow,
            )
        }
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Icon of star",
            tint = Color.Blue
        )
    }
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(12.dp),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
            contentColor = Color.Red,
            disabledContainerColor = Color.Red,
            disabledContentColor = Color.Red,
        ),
        border = BorderStroke(5.dp, Color.Cyan)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Example 1")
            Text(text = "Example 2")
            Text(text = "Example 3")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OtherComponentDefaultPreview() {
    Compose_catalogTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            MyDropdownMenu()
        }
    }
}