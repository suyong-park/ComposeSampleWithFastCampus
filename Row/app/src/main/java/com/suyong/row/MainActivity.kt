package com.suyong.row

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.suyong.row.ui.theme.RowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.wrapContentSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RowExample()
                }
            }
        }
    }
}

@Composable
fun RowExample() {
    Column {
        Row(
            modifier = Modifier
                .height(40.dp)
        ) {
            Text(text = "First", modifier = Modifier.align(Alignment.Top)) // Row 는 가로로 배치되는 레이아웃이다. 따라서, RowScope 의 align 메서드는 세로로 배치되게 된다.
            Text(text = "Second", modifier = Modifier.align(Alignment.CenterVertically))
            Text(text = "Third", modifier = Modifier.align(Alignment.Bottom))
        }

        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .height(40.dp)
        ) {
            Text(text = "First1", modifier = Modifier.align(Alignment.Top))
            Text(text = "Second2")
            Text(text = "Third3")
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .height(40.dp)
                .width(200.dp)
        ) {
            Text(text = "First1", modifier = Modifier.align(Alignment.Top))
            Text(text = "Second2")
            Text(text = "Third3")
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .height(40.dp)
                .width(200.dp)
        ) {
            Text(
                text = "First1",
                textAlign = TextAlign.End,
                modifier = Modifier
                    .align(Alignment.Top)
                    .weight(3f)
                    .background(Color.Magenta)
            )
            Icon(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = "Add Icon",
                modifier = Modifier.weight(1f)
                    .background(Color.Cyan)
            )
            Text(
                text = "Third3",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(3f)
                    .background(Color.Blue)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RowPreview() {
    RowTheme {
        RowExample()
    }
}