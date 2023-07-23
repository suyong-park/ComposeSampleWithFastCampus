package com.suyong.boxwithconstraints

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.suyong.boxwithconstraints.ui.theme.BoxWithConstraintsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxWithConstraintsTheme {
                // BoxWithConstraint 는 자주 사용되지는 않으나, width 혹은 height 가 얼마 이상일 때 무엇을 넣겠다 등인 경우 사용 가능하다.
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.wrapContentSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Outer()
                }
            }
        }
    }
}

@Composable
fun Outer() {
    Column(modifier = Modifier.width(150.dp)) {
        Inner(
            modifier = Modifier
                .width(200.dp) // 이 경우, parent 가 150 dp 로 할당받았기 때문에 child 는 200 dp 를 할당받지 못한다.
                .height(160.dp)
        )
    }
}

/**
 * BoxWithConstraint 는 기존 Box 의 기능은 모두 사용할 수 있으며,
 * Constraint, min-max height/width 를 사용할 수 있다.
 */
@Composable
fun Inner(
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier
    ) {
        if (maxHeight > 150.dp) {
            Text(
                text = "여기 정말 길군요!",
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
        Text(
            text = "maxWidth=$maxWidth, maxHeight=$maxHeight, minWidth=$minWidth, minHeight=$minHeight"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BoxWithConstraintsTheme {
        Outer()
    }
}