package com.essycynthia.mobcv.ui.theme.util

sealed class Screen(val route:String){
    object CvScreen : Screen("cv")
    object EditableScreen : Screen("edit_cv")
}
