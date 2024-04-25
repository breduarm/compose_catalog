package com.beam.composecatalog

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beam.composecatalog.ui.theme.Compose_catalogTheme
import kotlinx.coroutines.launch

@Composable
fun MyScaffold() {

    val coroutineScope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) },
        topBar = {
            MyTopAppBar(
                onClickIcon = { actionType ->
                    coroutineScope.launch {
                        snackBarHostState.showSnackbar("Action = $actionType")
                    }
                }
            )
        }
    ) {
        it.calculateTopPadding()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit) {
    TopAppBar(
        title = {
            Text(text = "This is a top app bar")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.Yellow,
        ),
        modifier = Modifier.shadow(
            elevation = 16.dp,
            spotColor = Color.Red
        ),
        navigationIcon = {
            IconButton(onClick = { onClickIcon("BACK") }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back navigation",
                    tint = Color.Yellow
                )
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("SEARCH") }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search action",
                    tint = Color.Yellow
                )
            }
            IconButton(onClick = { onClickIcon("CLOSE") }) {
                Icon(
                    imageVector = Icons.Filled.Dangerous,
                    contentDescription = "Close action",
                    tint = Color.Yellow
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AdvanceComponentsDefaultPreview() {
    Compose_catalogTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            MyScaffold()
        }
    }
}