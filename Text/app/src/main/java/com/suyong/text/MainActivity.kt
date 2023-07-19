package com.suyong.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.suyong.text.ui.theme.TextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TextTest("Android")
                }
            }
        }
    }
}

@Composable
fun TextTest(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        // Color
        Text(
            text = "Hello $name!",
            modifier = modifier,
            color = Color.Red
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            color = Color(0xffff9944)
        )

        // fontSize
        Text(
            text = "Hello $name!",
            modifier = modifier,
            fontSize = 30.sp
        )

        // fontWeight
        Text(
            text = "Hello $name!",
            modifier = modifier,
            fontWeight = FontWeight.Bold
        )

        // fontFamily
        Text(
            text = "Hello $name!",
            modifier = modifier,
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            fontFamily = FontFamily.Monospace
        )

        // letterSpacing
        Text(
            text = "Hello $name!",
            modifier = modifier,
            fontFamily = FontFamily.Monospace,
            letterSpacing = 2.sp,
        )

        // maxLines
        Text(
            text = "Hello $name! Hello $name! Hello $name! Hello $name!",
            modifier = modifier,
            maxLines = 2
        )

        // TextDecoration
        Text(
            text = "Hello $name!",
            modifier = modifier,
            textDecoration = TextDecoration.Underline
        )

        // align center
        Text(
            text = "Hello $name!",
            modifier = Modifier.width(300.dp),
            textAlign = TextAlign.End
        )

        Text(
            text = "Hello $name!",
            modifier = modifier,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextTheme {
        TextTest("Android")
    }
}