package com.suyong.checkbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.suyong.checkbox.ui.theme.CheckBoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckBoxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.wrapContentSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CheckBoxSample()
                }
            }
        }
    }
}

@Composable
fun CheckBoxSample() {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            /**
             * composable 메서드의 상태가 변경되게끔 하려면 상태화 시켜야 한다.
             * Recomposition 될 때 해당 상태값을 잊지 않도록 remember 시킨다.
             */
            val isChecked = remember { mutableStateOf(false) }
            Checkbox(
                checked = isChecked.value,
                onCheckedChange = { isChecked.value = !isChecked.value }
            )

            Text(
                text = "프로그래머 이신가요?"
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            var isChecked by remember { mutableStateOf(false) }

            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = !isChecked }
            )

            Text(
                text = "프로그래머 이신가요? 2"
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            // 아래 코드는 MutableState 구현체를 확인해 보면, component1 과 component2 를 통해 사용할 수 있는 문법이다
            val (getter, setter) = remember { mutableStateOf(false) }
            Checkbox(
                checked = getter,
                onCheckedChange = setter
            )

            Text(
                text = "프로그래머 이신가요?",
                modifier = Modifier.clickable {
                    setter(!getter)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CheckBoxTheme {
        CheckBoxSample()
    }
}