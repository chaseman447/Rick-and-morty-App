package com.example.rickandmorty.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.rickandmorty.characters.presentation.CharactersViewModel
import com.example.rickandmorty.character.CharacterScreen
import com.example.rickandmorty.character.CharacterViewModel
import com.example.rickandmorty.characters.presentation.CharactersScreen
import com.example.rickandmorty.location.presentation.LocationsScreen
import com.example.rickandmorty.location.presentation.LocationsViewModel

@Composable
fun MainNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Locations.route
    ) {
        composable(
            route = Routes.Characters.route,
        ) {
            val viewModel = viewModel<CharactersViewModel>()
            val state = viewModel.state.collectAsState()

            CharactersScreen(
                state = state,
                navigateTocharacter = { navController.navigate(Routes.Character.route + "/${it}") },
            )
        }
        composable(
            route = Routes.Character.route + "/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.StringType
                }
            )
        ) { backstackEntry ->
            val viewModel = viewModel<CharacterViewModel>()
            val state = viewModel.state.collectAsState()
            viewModel.getCharacter(backstackEntry.arguments?.getString("id")!!)

            CharacterScreen(
                state = state
            )
        }
        composable(
            route = Routes.Locations.route,
        ) {
            val viewModel = viewModel<LocationsViewModel>()
            val state = viewModel.state.collectAsState()

            LocationsScreen(
                state = state,
            )
        }
    }
}

enum class Routes(
    val route: String,
) {
    Characters(route = "Characters"),
    Character(route = "Character"),
    Locations(route = "Locations")
}