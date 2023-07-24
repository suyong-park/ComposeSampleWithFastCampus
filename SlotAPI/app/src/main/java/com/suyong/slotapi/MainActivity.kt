package com.suyong.slotapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.suyong.slotapi.ui.theme.SlotAPITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlotAPITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SlotAPIExample()
                }
            }
        }
    }
}

/**
 * Column 이나 Row 등은 Scope 내부에서 또 다른 Composable 을 정의하고 선언하여 사용할 수 있다.
 * 이렇게 특정 composable 이 다른 composable 을 받거나 포함할 수 있게 되어 있는 것을 slot api 라고 한다.
 */
@Composable
fun SlotAPIExample() {
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }

    Column {
//        CheckBoxWithText(checked = checked1) {
//            Text(
//                text = "텍스트1"
//            )
//        }
//        CheckBoxWithText(checked = checked2) {
//            Text(
//                text = "텍스트2"
//            )
//        }

        CheckBoxWithText(
            checked = checked1,
            onCheckedChanged = {
                checked1 = !checked1
            }
        ) {
            Text(text = "텍스트1")
        }

        CheckBoxWithText(
            checked = checked2,
            onCheckedChanged = {
                checked2 = !checked2
            }
        ) {
            Text(text = "텍스트2")
        }
    }
}

/**
 * Slot API 를 사용할 때는 메서드의 맨 마지막을 주로 사용한다. (호출부에서 편하게 scope 을 열어 사용할 수 있게끔)
 */
//@Composable
//fun CheckBoxWithText(
//    checked: MutableState<Boolean>,
//    content: @Composable () -> Unit
//) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clickable {
//            checked.value = !checked.value
//        }
//    ) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        content()
//    }
//}

/**
 * Slot API 의 람다를 RowScope 로 세팅하게 되면 각각 RowScope 에 있는 것처럼 사용할 수 있다.
 * 이렇게 사용하면 호출부에서도 RowScope 에 있는 것처럼 사용 가능하다.
 */
@Composable
fun CheckBoxWithText(
    checked: Boolean,
    onCheckedChanged: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onCheckedChanged()
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChanged() }
        )
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SlotAPITheme {
        SlotAPIExample()
    }
}