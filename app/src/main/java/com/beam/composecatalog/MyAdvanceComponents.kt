package com.beam.composecatalog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                MyModalDrawer {
                    coroutineScope.launch {
                        drawerState.close()
                    }
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            snackbarHost = { SnackbarHost(snackBarHostState) },
            topBar = {
                MyTopAppBar(
                    onClickIcon = { actionType ->
                        coroutineScope.launch {
                            snackBarHostState.showSnackbar("Action = $actionType")
                        }
                    },
                    onClickDrawer = {
                        coroutineScope.launch {
                            drawerState.open()
                        }
                    }
                )
            },
            bottomBar = {
                MyNavigationBar()
            },
            floatingActionButton = {
                MyFloatingActionButton()
            },
            floatingActionButtonPosition = FabPosition.Center,
        ) {
            it.calculateTopPadding()
        }
    }
}

@Composable
fun MyModalDrawer(onClickDrawer: () -> Unit) {
    Column(modifier = Modifier.padding(8.dp)) {
        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            onClick = onClickDrawer
        ) {
            Text(text = "Option 1")
        }
        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            onClick = onClickDrawer
        ) {
            Text(text = "Option 2")
        }
        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            onClick = onClickDrawer
        ) {
            Text(text = "Option 3")
        }
    }
}

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = Color.Blue,
        contentColor = Color.White
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}

@Composable
fun MyNavigationBar() {
    var index by remember { mutableIntStateOf(0) }
    NavigationBar(containerColor = Color.Red, contentColor = Color.Blue) {
        NavigationBarItem(
            selected = index == 0,
            onClick = { index = 0 },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
            label = { Text(text = "Home") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                indicatorColor = Color.Blue,
                unselectedIconColor = Color.Yellow,
                unselectedTextColor = Color.Yellow,
                disabledIconColor = Color.Gray,
                disabledTextColor = Color.Gray,
            )
        )
        NavigationBarItem(
            selected = index == 1,
            onClick = { index = 1 },
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorites") },
            label = { Text(text = "Favorites") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                indicatorColor = Color.Blue,
                unselectedIconColor = Color.Yellow,
                unselectedTextColor = Color.Yellow,
                disabledIconColor = Color.Gray,
                disabledTextColor = Color.Gray,
            )
        )
        NavigationBarItem(
            enabled = false,
            selected = index == 2,
            onClick = { index = 2 },
            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Account") },
            label = { Text(text = "Person") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                indicatorColor = Color.Blue,
                unselectedIconColor = Color.Yellow,
                unselectedTextColor = Color.Yellow,
                disabledIconColor = Color.Gray,
                disabledTextColor = Color.Gray,
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onClickDrawer: () -> Unit) {
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
            IconButton(onClick = onClickDrawer) {
                Icon(
                    imageVector = Icons.Filled.Menu,
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