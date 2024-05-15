package tw.edu.pu.csim.s1114679.gesture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import tw.edu.pu.csim.s1114679.gesture.ui.theme.GestureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GestureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    Tap()
                }
            }
        }
    }
}
    @Composable
    fun PointerEvents() {
        var msg by remember { mutableStateOf("") }
        Column {
            Text(msg)
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Yellow)
                    .pointerInput(Unit) {
                        awaitPointerEventScope {
                            while (true) {
                                val event = awaitPointerEvent()
                                msg = "${event.type}, ${event.changes.first().position}"
                            }
                        }
                    }

            )
        }
    }
    @Composable
    fun Tap() {
        var msg by remember { mutableStateOf("TAP相關手勢實例") }

        Column {
            Text(text = msg)

            Image(
                painter = painterResource(id = R.drawable.pu0),
                contentDescription = "靜宜之美",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
