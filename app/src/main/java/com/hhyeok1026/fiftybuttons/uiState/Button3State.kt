package com.hhyeok1026.fiftybuttons.uiState

import androidx.annotation.ColorRes

data class Button3State(
    val isClicked: Boolean,
    val text: String,

    @ColorRes
    val tint: Int
)