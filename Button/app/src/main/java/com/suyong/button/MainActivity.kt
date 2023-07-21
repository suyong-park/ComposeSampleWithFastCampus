package com.suyong.button

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.suyong.button.ui.theme.ButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ButtonExample(
                        onButtonClicked = {
                            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ButtonExample(onButtonClicked: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = onButtonClicked,
            enabled = false // 클릭이 되지 않으면서 버튼 색상이 비활성화 된 것 처럼 바뀜
        ) {
            Icon(
                imageVector = Icons.Filled.Send, // Icons 객체에서 Material Image 에 접근이 가능하다.
                contentDescription = null
            )

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing)) // Material 기본 아이콘 간격

            Text(text = "Send")
        }

        Button(
            onClick = onButtonClicked,
            enabled = true,
            border = BorderStroke(10.dp, Color.Magenta)
        ) {
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = null
            )

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))

            Text(text = "Send")
        }

        Button(
            onClick = onButtonClicked,
            enabled = true,
            border = BorderStroke(10.dp, Color.Magenta),
            shape = CircleShape
        ) {
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = null
            )

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))

            Text(text = "Send")
        }

        Button(
            onClick = onButtonClicked,
            enabled = true,
            border = BorderStroke(10.dp, Color.Magenta),
            shape = CircleShape,
            contentPadding = PaddingValues(20.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = null
            )

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))

            Text(text = "Send")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    ButtonTheme {
        ButtonExample({  })
    }
}