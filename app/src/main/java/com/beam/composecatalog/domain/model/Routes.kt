package com.beam.composecatalog.domain.model

sealed class Routes(val route: String) {
    data object Screen1 : Routes("screen1")
    data object Screen2 : Routes("screen2")
    data object Screen3 : Routes("screen3")
    data class Screen4(val name: String) : Routes("screen4/$name")
}