package com.example.roomhiltcomposeexample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val items = mapOf<String, String>(
        "user1" to "https://randomuser.me/api/portraits/thumb/men/1.jpg",
        "user2" to "https://randomuser.me/api/portraits/thumb/men/2.jpg",
        "user3" to "https://randomuser.me/api/portraits/thumb/men/3.jpg",
    ).toList()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("MainScreen")
                }
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            items(items = items) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    AsyncImage(
                        model = it.second,
                        modifier = Modifier
                            .padding(6.dp)
                            .height(60.dp)
                            .width(60.dp),
                        contentDescription = "Translated description of what the image contains",
                        contentScale = ContentScale.FillBounds,
                    )
                    Text(
                        modifier = Modifier
                            .padding(vertical = 18.dp, horizontal = 8.dp),
                        text = it.first
                    )
                }
                HorizontalDivider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}