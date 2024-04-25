package com.beam.composecatalog

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beam.composecatalog.domain.SuperHero
import com.beam.composecatalog.ui.theme.Compose_catalogTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyRecyclerViewWithStickyHeader() {
    val context = LocalContext.current
    val superHeroes = getSuperHeroes().groupBy { it.publisher }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        superHeroes.forEach { (publisher, superheroList) ->
            stickyHeader {
                Text(
                    text = publisher,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    fontSize = 20.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            }
            items(superheroList) { superHero ->
                ItemHero(superHero) {
                    Toast.makeText(context, it.nickname, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun MyRecyclerViewSuperHeroesWithControls() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeroes()) { superHero ->
                ItemHero(superHero) {
                    Toast.makeText(context, it.nickname, Toast.LENGTH_SHORT).show()
                }
            }
        }

        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }

        if (showButton) {
            Button(modifier = Modifier.fillMaxWidth(), onClick = {
                coroutineScope.launch {
                    rvState.animateScrollToItem(0)
                }
            }) {
                Text(text = "Back to top")
            }
        }
    }
}

@Composable
fun MyRecyclerViewSuperHeroesGrid() {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(getSuperHeroes()) { superHero ->
            ItemHero(superHero) {
                Toast.makeText(context, it.nickname, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun MyRecyclerViewSuperHeroes() {
    val context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) { superHero ->
            ItemHero(superHero) {
                Toast.makeText(context, it.nickname, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onItemSelected(superHero)
        }
    ) {
        Image(
            painter = painterResource(id = superHero.photoRes),
            contentDescription = "Super hero image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = superHero.nickname,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = superHero.name,
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = superHero.publisher,
            fontSize = 10.sp,
            modifier = Modifier
                .align(Alignment.End)
                .padding(8.dp)
        )
    }
}

@Composable
fun MySimpleRecyclerView() {
    val bookList = listOf(
        "Dune",
        "Neuromancer",
        "Foundation",
        "1984",
        "Brave New World",
        "The Hitchhiker's Guide to the Galaxy",
        "The War of the Worlds",
        "Snow Crash",
        "Ender's Game",
        "Hyperion"
    )
    LazyColumn {
        item { Text(text = "Item 1") }
        items(count = 10) { index ->
            Text(text = "Item $index in items")
        }
        items(bookList) { book ->
            Text(text = "Book title = $book")
        }
        item { Text(text = "This is the last custom item") }
    }
}

@Preview(showBackground = true)
@Composable
fun RecyclerViewDefaultPreview() {
    Compose_catalogTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            MyRecyclerViewWithStickyHeader()
        }
    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero(
            nickname = "Spiderman",
            name = "Petter Parker",
            publisher = "Marvel",
            R.drawable.spiderman,
        ),
        SuperHero(
            nickname = "Wolverine",
            name = "James Howlett",
            publisher = "Marvel",
            R.drawable.logan,
        ),
        SuperHero(
            nickname = "Batman",
            name = "Bruce Wayne",
            publisher = "DC Comics",
            R.drawable.batman,
        ),
        SuperHero(
            nickname = "Thor",
            name = "Thor Odinson",
            publisher = "Marvel",
            R.drawable.thor,
        ),
        SuperHero(
            nickname = "Flash",
            name = "Barry Allen",
            publisher = "DC Comics",
            R.drawable.flash,
        ),
        SuperHero(
            nickname = "Green Lantern",
            name = "John Stewart",
            publisher = "DC Comics",
            R.drawable.green_lantern
        ),
        SuperHero(
            nickname = "Wonder Woman",
            name = "Diana Prince",
            publisher = "DC Comics",
            R.drawable.wonder_woman
        )
    )
}