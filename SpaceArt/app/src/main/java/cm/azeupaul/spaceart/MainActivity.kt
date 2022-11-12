package cm.azeupaul.spaceart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cm.azeupaul.spaceart.ui.theme.SpaceArtTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceArtTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SpaceArtScreen()
                }
            }
        }
    }
}

@Composable
fun SpaceArtScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Surface(
            modifier = Modifier.fillMaxWidth(),
            elevation = 16.dp,
            border = BorderStroke(3.dp, color = Color.LightGray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.swirling_smoke),
                contentDescription = null
            )
        }

        Surface(
            modifier = Modifier.fillMaxWidth(),
            elevation = 16.dp) {
            SpaceArtwork(
                title = "Artwork title",
                artist = "Artwork artist",
                year = "Year",
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth().align(alignment = Alignment.CenterHorizontally),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ){
            Button(
                modifier = Modifier.padding(8.dp),
                onClick = { /*TODO*/ }) {
                Text(text = "Previous")
            }

            Button(
                modifier = Modifier.padding(8.dp),
                onClick = { /*TODO*/ }) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun SpaceArtWall(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Space Art Wall")
        SpaceArtwork(title = "Artwork title", artist = "Artwork artist", year = "2022")
    }
}

@Composable
fun SpaceArtwork(title: String, artist: String, year: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
    ) {
        Text(text = title, fontSize = 25.sp, fontWeight = FontWeight.Light)
        Row {
            Text(text = artist, fontWeight = FontWeight.Bold)
            Text(text = " (", fontWeight = FontWeight.Light)
            Text(text = year, fontWeight = FontWeight.Light)
            Text(text = ")", fontWeight = FontWeight.Light)
        }
    }
}

@Composable
fun SpaceControllers(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Previous")
        }

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SpaceArtTheme {
        SpaceArtScreen()
    }
}