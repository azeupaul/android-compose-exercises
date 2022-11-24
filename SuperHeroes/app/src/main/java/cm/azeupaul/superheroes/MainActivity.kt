package cm.azeupaul.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cm.azeupaul.superheroes.model.HeroesRepository
import cm.azeupaul.superheroes.model.SuperHero
import cm.azeupaul.superheroes.ui.theme.SuperHeroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SuperHeroApp()
                }
            }
        }
    }
}

@Composable
fun SuperHeroApp()
{
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .height(56.dp),
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.background
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.h1,
                        color = MaterialTheme.colors.onSurface
                    )
                }
            }
        }
    ) {
        HeroList(heroes = HeroesRepository.heroes)
    }
}

@Composable
fun HeroList(heroes: List<SuperHero>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
    ) {
        items(heroes) {
            HeroItem(hero = it, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        }
    }
}

@Composable
fun HeroItem(hero: SuperHero, modifier: Modifier = Modifier) {
    Card(
        elevation = 2.dp,
        modifier = modifier,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(74.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.body1
                )
            }

            Image(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(74.dp)
                    .clip(RoundedCornerShape(8.dp))
                ,
                contentScale = ContentScale.Crop,
                painter = painterResource(id = hero.imageRes),
                contentDescription = stringResource(id = hero.nameRes),

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    SuperHeroesTheme {
        SuperHeroApp()
    }
}

@Preview(showBackground = true)
@Composable
fun AppDarkPreview() {
    SuperHeroesTheme(darkTheme = true) {
        SuperHeroApp()
    }
}
