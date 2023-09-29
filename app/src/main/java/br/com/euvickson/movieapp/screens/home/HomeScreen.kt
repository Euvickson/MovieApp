package br.com.euvickson.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.euvickson.movieapp.MovieRow
import br.com.euvickson.movieapp.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Column {
        TopAppBar(
            title = { Text(text = "Movies") },
            colors = TopAppBarDefaults
                .smallTopAppBarColors(
                    containerColor = Color.Magenta
                )
        )
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    movieList: List<String> = listOf(
        "Avatar...",
        "300...",
        "Harry Potter...",
        "Life...",
        "Happiness...",
        "Cross the Line...",
        "Be Happy...",
        "Pink Panther...",
        "Interstellar"
    ), navController: NavController
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn() {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreens.DetailScreen.name+"/$movie")
                }
            }
        }
    }
}