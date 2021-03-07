package com.example.jetpackcomposecodelbabs

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecodelbabs.ui.theme.JetpackComposeCodelbabsTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetpackComposeCodelbabsTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))

}

@Preview("Screen Preview")
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}

@Composable
fun MyScreenContent(nameList: List<String> = listOf("Raphael", "Linus", "John", "Joy")) {
    val counter = remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxHeight()) {
        //weight is used to declare that the column will fill all the unoccupied space
        Column(modifier = Modifier.weight(1f)) {
            for (name in nameList) {
                Greeting(name = name)
                Divider(color = Color.Black)
            }
            Text(
                text = "The total number of people is ${nameList.size}",
                modifier = Modifier.padding(24.dp)
            )
            Divider(color = Color.Black, thickness = 32.dp)
        }
        Counter(counter.value) { newInt ->
            counter.value = newInt
        }
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(count + 1) },
        modifier = Modifier.padding(24.dp),
        //ButtonColors are necessary for they set the background AND content colors.
        colors = ButtonDefaults.buttonColors(
            //Leveraging Kotlin in compose
            backgroundColor = when (count % 3) {
                1 -> Color.Red
                2 -> Color.Green
                else -> Color.Blue
            }, contentColor = if (count % 3 == 0) Color.White else Color.Black
        )
    ) {
        Text(text = "The button has been clicked $count times")
    }
}