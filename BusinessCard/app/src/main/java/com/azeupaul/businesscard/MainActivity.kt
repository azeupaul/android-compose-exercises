package com.azeupaul.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.azeupaul.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFF6200EE))
    ) {
        ProfileSection(modifier = Modifier.weight(2f))
        InformationSection(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = stringResource(R.string.logo_android_description),
            modifier = Modifier.width(100.dp).height(100.dp)
        )
        Text(
            text = stringResource(R.string.title_name_text),
            style = MaterialTheme.typography.h3,
            color = Color.White
        )
        Text(
            text = stringResource(R.string.job_description_text),
            style = MaterialTheme.typography.body1,
            color = Color.Green
        )
    }
}

@Composable
fun InformationSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(
            modifier = Modifier
                .height(2.dp)
                .background(Color.White)
                .fillMaxWidth()
                .background(color = Color.DarkGray)
        )
        Row (
            modifier = Modifier.padding(start = 30.dp, top = 20.dp, bottom = 20.dp)
        ) {
            Icon(
                Icons.Rounded.Phone,
                contentDescription = stringResource(R.string.phone_icon_description),
                tint = Color.Green,
                modifier = Modifier.padding(end = 20.dp)
            )
            Text(
                text = stringResource(R.string.phone_number_content),
                color = Color.White
            )
        }
        Spacer(
            modifier = Modifier
                .height(2.dp)
                .background(Color.White)
                .fillMaxWidth()
                .background(color = Color.DarkGray)
        )
        Row (
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.padding(start = 30.dp, top = 20.dp, bottom = 20.dp)
        ) {
            Icon(
                Icons.Rounded.Share,
                contentDescription = stringResource(R.string.share_icon_description),
                tint = Color.Green,
                modifier = Modifier.padding(end = 20.dp)
            )
            Text(
                text = stringResource(R.string.share_username_text),
                color = Color.White
            )
        }
        Spacer(
            modifier = Modifier
                .height(2.dp)
                .background(Color.White)
                .fillMaxWidth()
                .background(color = Color.DarkGray)
        )
        Row (
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.padding(start = 30.dp, top = 20.dp)
        ) {
            Icon(
                Icons.Rounded.Email,
                contentDescription = stringResource(R.string.email_icon_description),
                tint = Color.Green,
                modifier = Modifier.padding(end = 20.dp)
            )
            Text(
                text = stringResource(R.string.email_text),
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}