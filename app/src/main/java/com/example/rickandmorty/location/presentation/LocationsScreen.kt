package com.example.rickandmorty.location.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.rickandmorty.R
import com.example.rickandmorty.location.data.remote.response.Location
import com.example.rickandmorty.location.presentation.state.LocationsState

@Composable
fun LocationsScreen(
    state: State<LocationsState>,
) {
    Locations(
        locations = state.value.locationList,
    )
}

@Composable
fun Locations(
    locations: List<Location>,
    modifier: Modifier = Modifier,
    navigateToLocation: (String) -> Unit = {}
) {
    Column {
        Text(
            text = "Location",
            fontSize = 30.sp
        )
        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(locations) { location ->
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
//                    .border(
//                        width = 5.dp,
//                        color = Color.Black,
//                        shape = RoundedCornerShape(20.dp)
//                    )
                        .padding(20.dp)
                        .clickable { navigateToLocation(location.id.toString()) }
                ) {
                    Image(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .fillMaxWidth()
                            .height(200.dp),
                        painter = painterResource(id = R.drawable.rick_morty_locations),
                        contentDescription = "",
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = location.name,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "type: ${location.type}",
                        fontSize = 10.sp
                    )
                    Text(
                        text = "dimension: ${location.dimension}",
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}