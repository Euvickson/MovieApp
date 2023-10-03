package br.com.euvickson.movieapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.euvickson.movieapp.model.Movie
import br.com.euvickson.movieapp.model.getMovies
import coil.compose.AsyncImage
import coil.transform.CircleCropTransformation


@Preview
@Composable
fun MovieRow(movie: Movie = getMovies()[0], onItemClicked: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable { onItemClicked(movie.id) },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp,
                color = Color.White
            ) {
                AsyncImage(model = movie.images[0], contentDescription = "Movie Poster", modifier = Modifier.clip(CircleShape), contentScale = ContentScale.Crop)
            }
            Column (modifier = Modifier.padding(4.dp)){
                Text(text = movie.title, style = MaterialTheme.typography.bodyMedium)
                Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.labelSmall)
                Text(text = "Released: ${movie.year}", style = MaterialTheme.typography.labelSmall)
            }

        }
    }
}
