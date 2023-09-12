package com.essycynthia.mobcv.ui.theme.util

sealed class UiEvent{
    object PopBackStack : UiEvent()
    data class Navigate(val route:String) : UiEvent()
    object ShowDialog : UiEvent()
}
