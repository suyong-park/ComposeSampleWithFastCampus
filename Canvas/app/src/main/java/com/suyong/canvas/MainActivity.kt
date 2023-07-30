package com.suyong.canvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.suyong.canvas.ui.theme.CanvasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun CanvasExample() {
    // Canvas 는 Modifier 가 Default Value 로 지정되지 않아 무조건 넣어줘야 한다.
    Canvas(modifier = Modifier.size(20.dp)) {
        // DrawScope 내부에는 사각형, 둥근 사각형, 원형, 이미지, 선형, 타원, 포인트 등등을 그릴 수 있는 메서드가 존재한다.
        drawLine(
            color = Color.Red,
            start = Offset(10f, 10f), // Offset 의 경우, 화면 상 좌표값을 의미한다. start 이므로 시작점의 좌표값
            end = Offset(20f, 20f) // end 이므로 마지막 지점의 좌표값
        )

        drawCircle(
            color = Color.Yellow,
            radius = 10f,
            center = Offset(15f, 40f) // 원의 중앙이 위치할 화면 상의 좌표값을 의미한다.
        )

        drawRect(
            color = Color.Magenta,
            topLeft = Offset(25f, 30f),
            size = Size(10f, 10f)
        )

        // Icons.Filled.Send 를 참고하면 아래와 같다. 같은 이미지를 Canvas 를 통해 그려보자.
        // ImageVector에서는 한붓 그리기 처럼 연속으로 그려집니다.
        // `moveTo`로 2.01f, 21.0f로 이동한 후 거기에서
        // 23.0f, 12.0f로 선이 그어지는 식입니다.

        //        moveTo(2.01f, 21.0f) // 커서의 위치를 함수 파라미터에 적힌 위치로 옮긴다
        //        lineTo(23.0f, 12.0f) // 커서의 위치를 기반으로 23.0f, 12.0f 까지 선을 긋는 것이다. (즉, 커서의 위치가 start 지점이 된다.)
        //        lineTo(2.01f, 3.0f) // 이전 메서드는 lineTo 메서드에 따라 선의 끝 지점이 커서의 위치가 된다.
        //        lineTo(2.0f, 10.0f)
        //        lineToRelative(15.0f, 2.0f) // 이전의 lineTo 메서드의 파라미터에서 전달했던 것에 lineToRelative 메서드의 파라미터로 전달된 값만큼 더 이동하겠다는 것이다.
        //        lineToRelative(-15.0f, 2.0f)
        //        close() // 처음 위치로 이동하게 된다.

        drawLine(
            color = Color.Green,
            start = Offset(2.01f, 21.0f),
            end = Offset(23.0f, 12.0f)
        )
        drawLine(
            color = Color.Green,
            start = Offset(23.0f, 12.0f),
            end = Offset(2.01f, 3.0f)
        )
        drawLine(
            color = Color.Green,
            start = Offset(2.01f, 3.0f),
            end = Offset(2.0f, 10.0f)
        )
        drawLine(
            color = Color.Green,
            start = Offset(2.01f, 3.0f),
            end = Offset(2.0f, 10.0f)
        )
        drawLine(
            color = Color.Green,
            start = Offset(2.0f, 10.0f),
            end = Offset(17.0f, 12.0f)
        )
        drawLine(
            color = Color.Green,
            start = Offset(17.0f, 12.0f),
            end = Offset(2.0f, 14.0f)
        )
        drawLine(
            color = Color.Green,
            start = Offset(2.0f, 14.0f),
            end = Offset(2.01f, 21.0f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CanvasPreview() {
    CanvasTheme {
        CanvasExample()
    }
}