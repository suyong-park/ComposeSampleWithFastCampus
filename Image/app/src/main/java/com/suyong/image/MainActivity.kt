package com.suyong.image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.suyong.image.ui.theme.ImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.wrapContentSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ImageExample()
                }
            }
        }
    }
}

@Composable
fun ImageExample() {
    Column() {
        Image(
            painter = painterResource(id = R.drawable.test),
            contentDescription = "태극기"
        )

        Image(
            imageVector = Icons.Filled.Settings,
            contentDescription = "설정"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImageTheme {
        ImageExample()
    }
}