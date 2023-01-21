package com.cdom.fitnessta

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ItemMain(
    val id: Int,
    @DrawableRes
    val drawableId: Int,
    @StringRes
    val txtStringId: Int,
    val color: Int,
)
