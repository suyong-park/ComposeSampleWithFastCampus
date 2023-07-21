package com.suyong.surface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.suyong.surface.ui.theme.SurfaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurfaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    SurfaceExample()
                }
            }
        }
    }
}

/**
 * Surface 는 Material Design 의 핵심 요소이다.
 * Elevation, Clipping, Border, Background 등이 있다.
 * Surface 는 뒤에 터치를 전달하지 않는다.
 */
@Composable
fun SurfaceExample() {
    Column {
        Surface(
            color = MaterialTheme.colors.surface,
            modifier = Modifier.padding(5.dp)
        ) {

            /**
             * 만약 Text 가 margin 을 가져야 한다면, Text 가 아니라 Surface 에 padding 을 설정하는 것이 좋다.
             * 성능을 위한 결정이라고 보면 된다.
             */
            Text(
                text = "TEST",
                modifier = Modifier.padding(8.dp)
            )
        }

        Surface(
            modifier = Modifier.padding(5.dp),
            elevation = 10.dp
        ) {
            Text(
                text = "TEST",
                modifier = Modifier.padding(8.dp)
            )
        }

        // elevation 이 있는 것을 표현하기 위해 적당한 수준의 padding 이 있는 것이 좋다
        Surface(
            modifier = Modifier.padding(5.dp),
            elevation = 10.dp,
            border = BorderStroke(2.dp, Color.Magenta)
        ) {
            Text(
                text = "TEST",
                modifier = Modifier.padding(8.dp)
            )
        }

        Surface(
            modifier = Modifier.padding(5.dp),
            elevation = 10.dp,
            shape = CircleShape
        ) {
            Text(
                text = "TEST",
                modifier = Modifier.padding(8.dp)
            )
        }

        /**
         * color 만 설정하고 contentColor 를 설정하지 않으면 Color 에 맞추어 적당한 ContentColor 가 세팅되게 된다.
         */
        Surface(
            modifier = Modifier.padding(5.dp),
            elevation = 10.dp,
            color = MaterialTheme.colors.primary
            // 위처럼 color 를 primary 로 고르면 content color 는 onPrimary 가 골라지게 된다. error의 경우 onError 가 골라 진다.
        ) {
            Text(
                text = "TEST",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SurfacePreview() {
    SurfaceTheme {
        SurfaceExample()
    }
}