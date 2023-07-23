package com.suyong.column

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.suyong.column.ui.theme.ColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.wrapContentSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ColumnExample()
                }
            }
        }
    }
}

@Composable
fun ColumnExample() {
    Column {
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.size(100.dp)
        ) {
            Text(text = "첫 번째")
            Text(text = "두 번째")
            Text(text = "세 번째")
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End,
            modifier = Modifier.size(100.dp)
        ) {
            Text(text = "첫 번째")
            Text(text = "두 번째")
            Text(text = "세 번째")
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End,
            modifier = Modifier.size(100.dp)
        ) {
            Text(
                text = "첫 번째",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "두 번째"
            )
            Text(
                text = "세 번째",
                modifier = Modifier.align(Alignment.Start)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnPreview() {
    ColumnTheme {
        ColumnExample()
    }
}