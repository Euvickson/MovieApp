package br.com.euvickson.movieapp.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.euvickson.movieapp.model.Movie
import br.com.euvickson.movieapp.model.getMovies
import br.com.euvickson.movieapp.widgets.MovieRow
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, movieId: String?) {

    val movie = getMovies().filter { movie ->
        movie.id == movieId
    }.first()

    Column {
        TopAppBar(
            title = { Text(text = "Movies") },
            colors = TopAppBarDefaults
                .smallTopAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = Color.Black
                ),
            navigationIcon = {
                Row {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow Back",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { navController.popBackStack() },
                        tint = Color.Black
                    )

                    Spacer(modifier = Modifier.width(100.dp))
                }
            }
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            MovieRow(movie = movie)

            Spacer(modifier = Modifier.height(8.dp))

            Divider(modifier = Modifier.padding(8.dp), color = Color.LightGray)

            Text(text = "Movie Images")

            HorizontalScrollableImageView(movie)

        }
    }
}

@Composable
private fun HorizontalScrollableImageView(movie: Movie) {
    LazyRow {
        items(movie.images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp), elevation = CardDefaults.cardElevation(5.dp)
            ) {
                Column(Modifier.fillMaxSize().background(color = Color.White), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                    AsyncImage(model = image, contentDescription = "Movie Poster")
                }
            }
        }
    }
}