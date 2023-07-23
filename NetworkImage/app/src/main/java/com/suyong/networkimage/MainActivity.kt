package com.suyong.networkimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.suyong.networkimage.ui.theme.NetworkImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetworkImageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.wrapContentSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NetworkImageSample()
                }
            }
        }
    }
}

@Composable
fun NetworkImageSample() {
    Column {
        val painter = rememberImagePainter(data = "https://search.pstatic.net/sunny/?src=https%3A%2F%2Fthumbs.dreamstime.com%2Fz%2Fflying-birds-dusk-japanese-town-walk-alone-river-bathe-watch-fly-sky-be-stained-golden-feel-particularly-relaxed-115642823.jpg&type=sc960_832")

        Image(
            painter = painter,
            contentDescription = "테스트이미지"
        )

        AsyncImage(
            model = "https://search.pstatic.net/sunny/?src=https%3A%2F%2Fthumbs.dreamstime.com%2Fz%2Fflying-birds-dusk-japanese-town-walk-alone-river-bathe-watch-fly-sky-be-stained-golden-feel-particularly-relaxed-115642823.jpg&type=sc960_832",
            contentDescription = "테스트이미지2"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NetworkImageTheme {
        NetworkImageSample()
    }
}