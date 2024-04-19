package com.beam.composecatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showBackground = true)
@Composable
fun MyConstraintLayout() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxGreen, boxYellow, boxCyan) = createRefs()

        Box(modifier = Modifier.size(100.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        })
        Box(modifier = Modifier.size(100.dp).background(Color.Green).constrainAs(boxGreen){
            bottom.linkTo(boxYellow.top)
            start.linkTo(boxYellow.end)
            end.linkTo(boxCyan.start)
        })
        Box(modifier = Modifier.size(100.dp).background(Color.Yellow).constrainAs(boxYellow){
            bottom.linkTo(boxRed.top)
            end.linkTo(boxRed.start)
        })
        Box(modifier = Modifier.size(100.dp).background(Color.Cyan).constrainAs(boxCyan){
            bottom.linkTo(boxRed.top)
            start.linkTo(boxRed.end)
        })
    }
}