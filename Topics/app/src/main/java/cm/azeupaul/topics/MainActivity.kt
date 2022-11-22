package cm.azeupaul.topics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cm.azeupaul.topics.data.DataSource
import cm.azeupaul.topics.model.Topic
import cm.azeupaul.topics.ui.theme.TopicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopicApp()
                }
            }
        }
    }
}

@Composable
fun TopicApp() {
    TopicList(topics = DataSource.topics)
}

@Suppress("OPT_IN_IS_NOT_ENABLED")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopicList(topics: List<Topic>) {
    LazyVerticalGrid(
        modifier = Modifier.padding(8.dp),
        cells = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(topics) { topic ->
            TopicCard(topic)
        }
    }
}


@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = 4.dp
    ) {
        Row {
            Image(
                modifier = Modifier
                    .size(68.dp)
                    .aspectRatio(1f),
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.nameResourceId),
                contentScale = ContentScale.FillHeight
            )
            Column(
                modifier = modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
            ) {
                Text(
                    modifier = modifier
                        .padding(bottom = 8.dp),
                    text = stringResource(id = topic.nameResourceId),
                    style = MaterialTheme.typography.body2
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = modifier
                            .size(12.dp),
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 8.dp),
                        text = topic.courses.toString(), style = MaterialTheme.typography.caption)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicCardPreview() {
    TopicsTheme {
        TopicCard(Topic(R.string.architecture, 58, R.drawable.architecture))
    }
}