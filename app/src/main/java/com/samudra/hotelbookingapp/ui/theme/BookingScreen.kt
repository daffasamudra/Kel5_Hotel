package com.samudra.hotelbookingapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samudra.hotelbookingapp.R

data class HotelDetail(
    val id: Int,
    val name: String,
    val address: String,
    val stars: Int,
    val rating: Float,
    val imageRes: Int
)

@Composable
fun BookingScreen(hotelDetail: HotelDetail, onBookClick: () -> Unit = {}) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.wallpaperflare_com_wallpaper__8_),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = hotelDetail.imageRes),
                contentDescription = hotelDetail.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = hotelDetail.name, style = MaterialTheme.typography.titleLarge)
            Text(text = hotelDetail.address, style = MaterialTheme.typography.bodyLarge)
            Text(text = "Stars: ${hotelDetail.stars}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Rating: ${hotelDetail.rating}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onBookClick) {
                Text(text = "Book")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookingScreenPreview() {
    val hotelDetail = HotelDetail(
        id = 1,
        name = "Hotel A",
        address = "123 Beachside Ave, Miami, FL",
        stars = 5,
        rating = 4.5f,
        imageRes = R.drawable.wallpaperflare_com_wallpaper__8_
    )
    BookingScreen(hotelDetail = hotelDetail)
}
