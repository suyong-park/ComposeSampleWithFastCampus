package com.suyong.composecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.suyong.composecard.ui.theme.ComposeCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.wrapContentSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        CardExample(card)
                        CardExample(card)
                    }
                }
            }
        }
    }

    companion object {
        val card = CardModel(
            imageUrl = "https://images.unsplash.com/photo-1661956603025-8310b2e3036d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80",
            imageDescription = "테스트 이미지",
            author = "Dalinaum",
            description = "이미지가 보이시나요?"
        )
    }
}

@Composable
fun CardExample(card: CardModel) {
    val placeHolderColor = Color(0x33000000)

    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(4.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp).fillMaxWidth()
        ) {
            AsyncImage(
                model = card.imageUrl,
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(placeHolderColor), // 이미지가 없는 경우, 해당 place holder 의 color 가 반영됨
                contentDescription = card.imageDescription,
                modifier = Modifier.size(100.dp)
                    .clip(CircleShape)
            )
            
            Spacer(modifier = Modifier.size(8.dp))

            Column {
                Text(
                    text = card.author
                )
                
                Spacer(modifier = Modifier.size(4.dp))

                Text(
                    text = card.description
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeCardTheme {
        CardExample(MainActivity.card)
    }
}

data class CardModel(
    val imageUrl: String,
    val imageDescription: String,
    val author: String,
    val description: String
)