package br.com.euvickson.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.euvickson.movieapp.screens.home.HomeScreen
import br.com.euvickson.movieapp.screens.detail.DetailScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name) {
        composable(MovieScreens.HomeScreen.name) {
            //Here we pass where this should lead us to
            HomeScreen(navController = navController)
        }

        composable(MovieScreens.DetailScreen.name+"/{movie}", arguments = listOf(navArgument(name = "movie") {type = NavType.StringType})) {backStackEntry ->

            DetailScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}