package com.azeupaul.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.azeupaul.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    QuadrantCard()
                }
            }
        }
    }
}

@Composable
fun SingleQuadrant(title: String, content: String , bgColor: Color, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(color = bgColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun QuadrantCard() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Row(Modifier.weight(1F)) {
            SingleQuadrant(
                stringResource(R.string.card_title_text_1),
                stringResource(R.string.card_content_text_1),
                Color.Green,
                Modifier.weight(1F)
            )
            SingleQuadrant(
                stringResource(R.string.card_title_text_2),
                stringResource(R.string.card_content_text_2),
                Color.Yellow,
                Modifier.weight(1F)
            )
        }
        Row(Modifier.weight(1F)) {
            SingleQuadrant(
                stringResource(R.string.card_title_text_3),
                stringResource(R.string.card_content_text_3),
                Color.Cyan,
                Modifier.weight(1F)
            )
            SingleQuadrant(
                stringResource(R.string.card_title_text_4),
                stringResource(R.string.card_content_text_4),
                Color.LightGray,
                Modifier.weight(1F)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantCardPreview() {
    ComposeQuadrantTheme {
        QuadrantCard()
    }
}