package com.suyong.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.suyong.textfield.ui.theme.TextFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TextFieldExample()
                }
            }
        }
    }
}

@Composable
fun TextFieldExample() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        var name by remember { mutableStateOf("Tom") }
        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text(text = "이름")
            }
        )

        Spacer(modifier = Modifier.size(8.dp))
        
        Text(text = "Hello $name")

        Spacer(modifier = Modifier.size(8.dp))

        var description by remember { mutableStateOf("Android Developer") }

        OutlinedTextField(
            value = description,
            onValueChange = {
                description = it
            }
        )

        Text(text = "description $description")
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldPreview() {
    TextFieldTheme {
        TextFieldExample()
    }
}