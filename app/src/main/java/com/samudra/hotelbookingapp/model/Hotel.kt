package com.samudra.hotelbookingapp.model

import com.samudra.hotelbookingapp.R

data class Hotel(val id: Int, val name: String, val imageRes: Int)

val dummyHotels = listOf(
    Hotel(1, "Hotel A", R.drawable.wallpaperflare_com_wallpaper__9_),
    Hotel(2, "Hotel B", R.drawable.wallpaperflare_com_wallpaper__9_)
)
