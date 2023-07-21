package com.suyong.modifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.suyong.modifier.ui.theme.ModifierTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifierTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.wrapContentSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ModifierExample()
                }
            }
        }
    }
}

@Composable
fun ModifierExample() {
    Column() {
        Button(
            onClick = {},
            modifier = Modifier
                .width(200.dp)
                .height(100.dp) // size 를 사용하는 것이 낫다.
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null
            )

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))

            Text(text = "Search")
        }

        Button(
            onClick = {},
            modifier = Modifier
                .size(200.dp, 100.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null
            )

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))

            Text(text = "Search")
        }

        Button(
            onClick = {},
            modifier = Modifier
                .size(200.dp, 100.dp)
                .background(color = Color.Red) // Button 에서는 Modifier 를 통한 background 설정으로 Color 변경이 불가능하다.
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null
            )

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))

            Text(text = "Search")
        }

        Button(
            onClick = {},
            modifier = Modifier
                .size(200.dp, 100.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta, // 버튼 자체의 색상
                contentColor = Color.Cyan// button 내부의 이미지, 텍스트
            ),
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null
            )

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))

            Text(text = "Search")
        }

        Button(
            onClick = {},
            modifier = Modifier
                .size(200.dp)
                .padding(10.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null
            )

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))

            Text(text = "Search")
        }

        Button(
            onClick = {},
            modifier = Modifier
                .size(200.dp, 100.dp)
                .padding(),
            enabled = false
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null
            )

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))

            Text(
                text = "Search",
                modifier = Modifier.clickable { } // Button 자체에서는 Enable 가 막혀있으나 Text 영역은 클릭 가능하다.
            )
        }

        Button(
            onClick = {},
            modifier = Modifier
                .size(200.dp, 100.dp)
                .padding()
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                modifier = Modifier.background(Color.Blue)
            )

            Spacer(
                modifier = Modifier
                    .size(ButtonDefaults.IconSpacing)
                    .background(Color.Blue)
            )

            Text(
                text = "Search",
                modifier = Modifier
                    .offset(x = 50.dp, y = 20.dp)
                    .background(Color.Blue)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierPreview() {
    ModifierTheme {
        ModifierExample()
    }
}