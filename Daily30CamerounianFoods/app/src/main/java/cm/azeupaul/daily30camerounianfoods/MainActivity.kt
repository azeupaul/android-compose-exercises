package cm.azeupaul.daily30camerounianfoods

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cm.azeupaul.daily30camerounianfoods.data.DataSource
import cm.azeupaul.daily30camerounianfoods.model.Food
import cm.azeupaul.daily30camerounianfoods.ui.theme.Daily30CamerounianFoodsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Daily30CamerounianFoodsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun FoodApp() {
    val foods = DataSource.foods
    FoodList(
        foods = foods,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun FoodList(
    foods: List<Food>, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            items(foods) { item: Food ->
                ItemFood(food = item, modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}

@Composable
fun ItemFood(
    food: Food,
    modifier: Modifier = Modifier
) {
    var expanded by remember {
      mutableStateOf(false)
    }

    val day = food.day.toString()
    val name = stringResource(id = food.name)
    val description = stringResource(id = food.content)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Row(
                modifier
                    .fillMaxWidth()
                    .height(30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Day $day - $name"
                )
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if(expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = "Dropdown button"
                    )
                }

            }
            if(expanded){
                Spacer(Modifier.height(12.dp))
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    painter = painterResource(id = food.image),
                    contentScale = ContentScale.Crop,
                    contentDescription = name,
                )
                Spacer(Modifier.height(12.dp))
                Text(text = description
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    Daily30CamerounianFoodsTheme {
        FoodApp()
    }
}