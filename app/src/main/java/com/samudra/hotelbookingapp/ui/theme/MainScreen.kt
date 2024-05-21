package com.samudra.hotelbookingapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samudra.hotelbookingapp.R
import com.samudra.hotelbookingapp.model.Hotel
import com.samudra.hotelbookingapp.model.dummyHotels

@Composable
fun MainScreen(onHotelClick: (Hotel) -> Unit = {}) {
    var searchQuery by remember { mutableStateOf("") }
    val filteredHotels = if (searchQuery.isEmpty()) {
        dummyHotels
    } else {
        dummyHotels.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }

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
        Column(modifier = Modifier.padding(16.dp)) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text(text = "Search Hotels") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(filteredHotels) { hotel ->
                    HotelItem(hotel = hotel, onClick = { onHotelClick(hotel) })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
