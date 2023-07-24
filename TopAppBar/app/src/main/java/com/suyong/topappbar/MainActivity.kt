package com.suyong.topappbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.suyong.topappbar.ui.theme.TopAppBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopAppBarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopAppBarExample("TopAppBar")
                }
            }
        }
    }
}

@Composable
fun TopAppBarExample(name: String) {
    Column() {
//        TopAppBar(title = { Text(text = name) })
//        TopAppBar(
//            title = { Text(text = name) },
//            navigationIcon = {
//                IconButton(onClick = { }) {
//                    Icon(
//                        imageVector = Icons.Filled.ArrowBack,
//                        contentDescription = "Arrow Back"
//                    )
//                }
//            }
//        )
        TopAppBar(
            title = { Text(text = name) },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Arrow Back"
                    )
                }
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search"
                    )
                }

                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Settings"
                    )
                }

                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = "Account"
                    )
                }
            }
        )

        // 처음부터 RowScope 을 갖는 TopAppBar 가 존재한다.
        TopAppBar {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Arrow Back"
                )
            }
            // weight 가 해당 scope 에서 1개만 있는 경우, 가용 가능한 사이즈를 모두 가져가게 된다.
            Text(text = name, modifier = Modifier.weight(1f))

            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search"
                )
            }

            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Settings"
                )
            }

            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = "Account"
                )
            }
        }

        Text(text = "Hello $name")
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBarTheme {
        TopAppBarExample("TopAppBar")
    }
}