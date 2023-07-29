package com.suyong.constraintcustomuse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.suyong.constraintcustomuse.ui.theme.ConstraintCustomUseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintCustomUseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ConstraintCustomUseExample()
                }
            }
        }
    }
}

@Composable
fun ConstraintCustomUseExample() {
    val placeHolderColor = Color(0x33000000)

    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(4.dp),
    ) {
        // 단계 1: 아래의 Row 레이아웃을 ConstraintLayout로 바꾸어 봅시다.
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            val (profileImage, author, description) = createRefs()

            AsyncImage(
                model = cardData.imageUri,
                contentDescription = cardData.imageDescription,
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(color = placeHolderColor),
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
                    .constrainAs(profileImage) {
                        centerVerticallyTo(parent)
                        start.linkTo(parent.start, 8.dp)
                    }
            )

            Text(
                text = cardData.author,
                modifier = Modifier.constrainAs(author) {
                    linkTo(
                        start = profileImage.end,
                        end = parent.end,
                        startMargin = 8.dp,
                        endMargin = 8.dp
                    )
                    width = Dimension.fillToConstraints // width 를 제약 만큼만 채워주는 것
                }
            )

            Text(
                text = cardData.description,
                modifier = Modifier.constrainAs(description) {
                    linkTo(
                        start = profileImage.end,
                        end = parent.end,
                        startMargin = 8.dp,
                        endMargin = 8.dp
                    )
                    width = Dimension.fillToConstraints // width 를 제약 만큼만 채워주는 것
                }
            )

            val chain = createVerticalChain(
                author,
                description,
                chainStyle = ChainStyle.Packed
            )

            constrain(chain) {
                top.linkTo(parent.top, 8.dp)
                bottom.linkTo(parent.bottom, 8.dp)
            }
        }

//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier.padding(8.dp)
//        ) {
//            AsyncImage(
//                model = cardData.imageUri,
//                contentDescription = cardData.imageDescription,
//                contentScale = ContentScale.Crop,
//                placeholder = ColorPainter(color = placeHolderColor),
//                modifier = Modifier
//                    .clip(CircleShape)
//                    .size(40.dp)
//            )
//            Spacer(modifier = Modifier.size(8.dp))
//            Column {
//                Text(text = cardData.author)
//                Text(text = cardData.description)
//            }
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintCustomUsePreview() {
    ConstraintCustomUseTheme {
        ConstraintCustomUseExample()
    }
}

data class CardData(
    val imageUri: String,
    val imageDescription: String,
    val author: String,
    val description: String
)

val cardData = CardData(
    imageUri = "https://raw.githubusercontent.com/Fastcampus-Android-Lecture-Project-2023/part1-chapter3/main/part1-chapter3-10/app/src/main/res/drawable-xhdpi/wall.jpg",
    imageDescription = "엔텔로프 캐년",
    author = "Dalinaum",
    description = "엔텔로프 캐년은 죽기 전에 꼭 봐야할 절경으로 소개되었습니다."
)