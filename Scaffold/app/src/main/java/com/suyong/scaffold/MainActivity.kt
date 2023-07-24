package com.suyong.scaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.suyong.scaffold.ui.theme.ScaffoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScaffoldExample()
                }
            }
        }
    }
}

@Composable
fun ScaffoldExample() {
    var checked by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Scaffold App")
                },
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Image(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "뒤로 가기"
                        )
                    }
                }
            )
        },
        bottomBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
                color = Color.Cyan
            ) {
                Text(
                    text = "BOTTOM Scaffold",
                    textAlign = TextAlign.Center
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {  }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Setting"
                )
            }
        }
    ) {
        Surface(modifier = Modifier.padding(it)) {
            CheckBoxWithContent(
                checked = checked,
                toggleState = { checked = !checked }
            ) {
                Text(text = "I LIKE COMPOSE")
            }
        }
    }
}

@Composable
fun CheckBoxWithContent(
    checked: Boolean,
    toggleState: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { toggleState() }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { toggleState() },
        )
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    ScaffoldTheme {
        ScaffoldExample()
    }
}