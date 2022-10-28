package com.azeupaul.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.azeupaul.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonTree(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonTree(modifier: Modifier = Modifier) {
    var currentStep by remember {
        mutableStateOf(1)
    }
    when(currentStep){
        1 -> {
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.lemon_tree_tap_title),
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.lemon_tree),
                    contentDescription = stringResource(
                        id = R.string.lemon_tree_content_description
                    ),
                    modifier = Modifier.border(
                        1.dp,
                        Color(105,205,216),
                        RoundedCornerShape(5.dp)
                    ).clickable { currentStep = 2 }
                )
            }
        }
        2 -> {
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.keep_lemon_tap_title),
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.lemon_squeeze),
                    contentDescription = stringResource(
                        id = R.string.lemon_content_description
                    ),
                    modifier = Modifier.border(
                        1.dp,
                        Color(105,205,216),
                        RoundedCornerShape(5.dp)
                    ).clickable { currentStep = 3 }
                )
            }
        }
        3 -> {
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.drink_lemonade_tap_title),
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.lemon_drink),
                    contentDescription = stringResource(
                        id = R.string.glass_content_description
                    ),
                    modifier = Modifier.border(
                        1.dp,
                        Color(105,205,216),
                        RoundedCornerShape(5.dp)
                    ).clickable { currentStep = 4 }
                )
            }
        }
        else -> {
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.empty_glass_tap_title),
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.lemon_restart),
                    contentDescription = stringResource(
                        id = R.string.empty_glass_content_description
                    ),
                    modifier = Modifier.border(
                        1.dp,
                        Color(105,205,216),
                        RoundedCornerShape(5.dp)
                    ).clickable { currentStep = 1 }
                )
            }
        }
    }
}