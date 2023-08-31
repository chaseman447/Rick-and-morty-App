package com.example.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rickandmorty.navigation.MainNavGraph
import com.example.rickandmorty.navigation.Routes
import com.example.rickandmorty.ui.theme.RickAndMortyTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.stopKoin

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initKoin {
            androidContext(applicationContext)
        }
        setContent {
            RickAndMortyTheme {
                val navController = rememberNavController()

//                val coroutineScope = rememberCoroutineScope()
//
//                coroutineScope.launch {
//                    CharactersClient().getCharacterById(id = "1")
//                }
                val backStackEntry = navController.currentBackStackEntryAsState()

                Scaffold(
                    bottomBar = {
                        androidx.compose.material3.NavigationBar(
                            containerColor = Color(0xFF23AFCA),
                        ) {
                            bottomNavItems.forEach { item ->
                                val selected =
                                    item.route == backStackEntry.value?.destination?.route

                                NavigationBarItem(
                                    alwaysShowLabel = false,
                                    selected = selected,
                                    onClick = { navController.navigate(item.route) },
                                    icon = {
                                        Icon(
                                            modifier = Modifier.size(50.dp),
                                            painter = painterResource(id = item.icon),
                                            contentDescription = "Icon",
                                        )
                                    },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = Color.White,
                                        unselectedIconColor = Color(0xFF92D5E6),
                                        selectedTextColor = Color.Transparent,
                                        indicatorColor = Color(0xFF23AFCA)
                                    ),
                                    modifier = Modifier.background(color = Color.Transparent)
                                )
                            }
                        }
                    }
                ) { paddingValues ->
                    Box(
                        modifier = Modifier
                            .padding(paddingValues)
                    ) {
                        MainNavGraph(navController = navController)
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopKoin()
    }
}

val bottomNavItems = listOf(
    BottomNavItem(
        route = Routes.Characters.route,
        icon = R.drawable.rick_and_morty_icon,
    ),
    BottomNavItem(
        route = Routes.Locations.route,
        icon = R.drawable.portal_gun,
    ),
)

data class BottomNavItem(
    val route: String,
    val icon: Int,
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RickAndMortyTheme {

    }
}