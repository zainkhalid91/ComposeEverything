package com.dev.composethingy.musicapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dev.composethingy.R
import com.dev.composethingy.ui.theme.ComposeThingyTheme
import com.dev.composethingy.ui.theme.DarkGray
import com.dev.composethingy.ui.theme.DarkGray_
import com.dev.composethingy.ui.theme.DarkPurple
import com.dev.composethingy.ui.theme.LightGray
import com.dev.composethingy.ui.theme.LightPurple

@Composable
fun DashBoardScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(DarkPurple, Color.Black), startY = 0f, endY = 1500f
                )
            )
    ) {
        val items = listOf(
            BottomNavItem("music", R.drawable.ic_music, "Music"),
            BottomNavItem("home", R.drawable.ic_home, "Home"),
            BottomNavItem("profile", R.drawable.ic_person, "Profile"),
            BottomNavItem("settings", R.drawable.ic_settings, "Settings")
        )

        var selectedIndex by remember { mutableIntStateOf(0) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            RoundedNavigationBar(items = items,
                selectedIndex = selectedIndex,
                onItemSelected = { newIndex -> selectedIndex = newIndex })
        }

        TopBar()
    }
}

@Composable
fun RoundedNavigationBar(
    items: List<BottomNavItem>, selectedIndex: Int, onItemSelected: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(95.dp)
            .padding(16.dp)
            .border(1.dp, DarkGray_, RoundedCornerShape(24.dp))
            .clip(RoundedCornerShape(24.dp))
            .background(DarkGray)
            .padding(8.dp)
    ) {
        NavigationBar(
            containerColor = Color.Transparent,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(24.dp))
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = index == selectedIndex
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Transparent)
                        .padding(vertical = 8.dp)
                ) {
                    IconButton(onClick = { onItemSelected(index) }) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.label,
                                tint = if (isSelected) Color.White else Color.Gray
                            )/*      Text(   //adds labels to the icons
                                      text = item.label,
                                      color = if (isSelected) Color.White else Color.Gray,
                                      fontSize = 8.sp,

                                      )*/
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TopBar() {
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                /*   Image(
                       painter = painterResource(id = R.drawable.four_squares),
                       contentDescription = "Profile Image",
                       contentScale = ContentScale.Crop, colorFilter = ColorFilter.tint(Color.White),
                       modifier = Modifier
                           .size(24.dp)
                           .align(alignment = Alignment.CenterStart)
                   )*/

                Image(
                    painter = painterResource(id = R.drawable.ic_profile_image),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .align(alignment = Alignment.CenterEnd)
                )
            }

            Spacer(modifier = Modifier.size(16.dp))


            Text(
                text = "Hello Zain!",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.size(24.dp))

            Text(
                text = "Find the best songs of 2024",
                style = MaterialTheme.typography.bodySmall,
                color = LightGray,
                modifier = Modifier.align(
                    Alignment.Start
                )
            )

            Spacer(modifier = Modifier.size(16.dp))

            SearchBar()


            Spacer(modifier = Modifier.size(24.dp))


            HorizontalScrollList()

        }
    }
}

@Composable
fun SearchBar() {
    var searchQuery by remember {
        mutableStateOf(TextFieldValue(""))
    }

    TextField(
        value = searchQuery,
        onValueChange = { newValue -> searchQuery = newValue },
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .border(1.dp, Color.White, shape = RoundedCornerShape(28.dp))
            .background(Color.Transparent, RoundedCornerShape(8.dp)),
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search Icon",
                tint = Color.White
            )
        },
        placeholder = {
            Text(
                text = "Looking for...",
                color = Color.White,
                style = MaterialTheme.typography.bodySmall
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(32.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = LightPurple,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}


@Composable
fun HorizontalScrollList() {
    val itemsSongs = listOf(
        Pair(painterResource(id = R.drawable.album_art_1), "Imagine Dragons" to "Night Visions"),
        Pair(painterResource(id = R.drawable.album_art_2), "Coldplay" to "Paradise"),
        Pair(painterResource(id = R.drawable.album_art_3), "Snow Patrol" to "Run")
    )

    val itemsAlbums = listOf(
        Pair(painterResource(id = R.drawable.album_art_1), "Night Visions" to "Night Visions"),
        Pair(painterResource(id = R.drawable.album_1), "Parachutes" to "Paradise"),
        Pair(painterResource(id = R.drawable.album_art_3), "Final Straw" to "Run")
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Popular Songs",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "See All",
            style = MaterialTheme.typography.bodyMedium,
            color = LightGray,
            fontSize = 14.sp,
        )
    }

    Spacer(modifier = Modifier.size(8.dp))


    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(itemsSongs.size) { index ->
            val item = itemsSongs[index]

            SongCard(image = item.first, title = item.second.first, artist = item.second.second)

        }
    }


    Spacer(modifier = Modifier.size(16.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Top Albums",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "See All",
            style = MaterialTheme.typography.bodyMedium,
            color = LightGray,
            fontSize = 14.sp,
        )
    }

    Spacer(modifier = Modifier.size(24.dp))

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(itemsAlbums.size) { index ->
            val item = itemsAlbums[index]
            AlbumCard(image = item.first, title = item.second.first)
        }
    }

}

@Composable
fun AlbumCard(image: Painter, title: String) {
    Column(modifier = Modifier.wrapContentSize()) {
        Box(
            modifier = Modifier
                .size(130.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = image, contentDescription = null, modifier = Modifier.fillMaxSize()
            )


        }

        Text(
            text = title, style = MaterialTheme.typography.bodyMedium,
            color = LightGray,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        )
    }


}

@Composable
fun SongCard(image: Painter, title: String, artist: String) {
    Box(modifier = Modifier.wrapContentSize()) {


        Box(
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = image, contentDescription = null, modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f)),
                contentAlignment = Alignment.BottomCenter
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = title,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    )

                    Text(
                        text = artist,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,

                        )
                }
            }
        }
        IconButton(
            onClick = { /* Handle play button click */ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = (8).dp, y = 16.dp) // Offset to position outside the box
                .size(32.dp)
                .background(Color.White, shape = RoundedCornerShape(50))
                .padding(4.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                contentDescription = "Play",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Dashboard() {
    ComposeThingyTheme {
        val navController = rememberNavController()
        DashBoardScreen(navController)
        TopBar()
    }
}


data class BottomNavItem(val route: String, val icon: Int, val label: String)

