package com.suyong.box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.suyong.box.ui.theme.BoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.wrapContentSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BoxExample()
                }
            }
        }
    }
}

@Composable
fun BoxExample() {
//    Box(modifier = Modifier.size(100.dp)) {
//        Text(
//            text = "Hello World",
//            modifier = Modifier.align(Alignment.BottomCenter)
//        )
//
//        Text(
//            text = "Jetpack",
//            modifier = Modifier.align(Alignment.CenterEnd)
//        )
//
//        Text(
//            text = "Compose",
//            modifier = Modifier.align(Alignment.TopStart)
//        )
//    }

//    Box(
//        modifier = Modifier.size(100.dp)
//    ) {
//        Box(
//            modifier = Modifier
//                .size(70.dp)
//                .background(Color.Cyan)
//                .align(Alignment.CenterStart)
//        )
//        Box(
//            modifier = Modifier
//                .size(70.dp)
//                .background(Color.Yellow)
//                .align(Alignment.BottomEnd)
//        )
//    }

    Box {
        Box(
            /**
             * matchParentSize 의 경우, 부모의 size 를 기준으로 해당 View 의 사이즈를 측정한다.
             * matchParentSize 는 align 과 함께 BoxScope 내부에서만 사용할 수 있다. (Extensions) 
             * 다만, 부모의 경우 자식이 지정된 70dp 를 보고 세팅하게 되므로, 첫 번째 박스는 두 번째 박스에 가려지게 될 것이다.
             * 그러나 fillMaxSize 로 지정하는 경우 가용 가능한 모든 사이즈로 뷰를 측정하게 된다.
             */
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan)
                .align(Alignment.CenterStart)
        )
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(Color.Yellow)
                .align(Alignment.BottomEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BoxPreview() {
    BoxTheme {
        BoxExample()
    }
}