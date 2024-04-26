package com.beam.composecatalog.domain.model

data class CheckInfo(
    val title: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit,
)
