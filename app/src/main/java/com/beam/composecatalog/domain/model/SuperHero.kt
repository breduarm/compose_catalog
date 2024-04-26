package com.beam.composecatalog.domain.model

import androidx.annotation.DrawableRes

data class SuperHero(
    var nickname: String,
    var name: String,
    var publisher: String,
    @DrawableRes var photoRes: Int,
)
