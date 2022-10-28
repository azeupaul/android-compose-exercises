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
    var currentStep by remember {
        mutableStateOf(1)
    }

    Surface(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)) {

        when(currentStep){
            1 -> {
                LemonTextWithImage(
                    R.drawable.lemon_tree,
                    R.string.lemon_tree_tap_title,
                    R.string.lemon_tree_content_description,
                    { currentStep = 2 }
                )
            }
            2 -> {
                val squeezeNumber = (2..4).random()
                var count = 0
                LemonTextWithImage(
                    R.drawable.lemon_squeeze,
                    R.string.keep_lemon_tap_title,
                    R.string.lemon_content_description,
                    {
                        if(count == squeezeNumber){
                            currentStep = 3
                        }else{
                            count++
                        }
                    }
                )
            }
            3 -> {
                LemonTextWithImage(
                    R.drawable.lemon_drink,
                    R.string.drink_lemonade_tap_title,
                    R.string.glass_content_description,
                    { currentStep = 4 }
                )
            }
            else -> {
                LemonTextWithImage(
                    R.drawable.lemon_restart,
                    R.string.empty_glass_tap_title,
                    R.string.empty_glass_content_description,
                    { currentStep = 1 }
                )
            }
        }
    }

}

@Composable
fun LemonTextWithImage(
    imageId: Int,
    textId: Int,
    descriptionId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = textId),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = imageId),
            contentDescription = stringResource(
                id = descriptionId
            ),
            modifier = Modifier
                .border(
                    1.dp,
                    Color(105, 205, 216),
                    RoundedCornerShape(5.dp)
                )
                .clickable { onImageClick() }
        )
    }
}