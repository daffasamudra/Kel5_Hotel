package com.samudra.hotelbookingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.samudra.hotelbookingapp.model.dummyHotels
import com.samudra.hotelbookingapp.ui.BookingScreen
import com.samudra.hotelbookingapp.ui.HotelDetail

class BookingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val hotelId = intent.getIntExtra("hotelId", 0)
        val hotel = dummyHotels.find { it.id == hotelId }
        setContent {
            hotel?.let {
                BookingScreen(
                    hotelDetail = HotelDetail(
                        id = it.id,
                        name = it.name,
                        address = "123 Beachside Ave, Miami, FL",
                        stars = 5,
                        rating = 4.5f,
                        imageRes = it.imageRes
                    )
                )
            }
        }
    }
}
