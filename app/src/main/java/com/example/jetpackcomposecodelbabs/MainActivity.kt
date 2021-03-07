package com.example.jetpackcomposecodelbabs

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
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

/**
 * MyApp can also be a container function that contains all the common app configurations such as
 * surface color and themes.
 * The container function takes a composable function as a lambda function parameter and acts on it
 * appropriately.
 *
 * Using container functions is good practice because it encourages code reusability and improves
 * code readability.
 */
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
    Column {
        for (name in nameList) {
            Greeting(name = name)
            Divider(color = Color.Black)
        }
        Text(
            text = "The total number of people is ${nameList.size}",
            modifier = Modifier.padding(24.dp)
        )
        Divider(color = Color.Black,thickness = 32.dp)
        //The state is controlled here.
        Counter(counter.value) { newInt ->
            counter.value = newInt
        }
    }
}

/**
 * State hoisting refers to hosting the state of a composable in one function but controlling
 * the state in another composable that calls it.
 */
@Composable
//By introducing the two parameters, state is hoisted in that it is allowed to be defined elsewhere.
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(onClick = { updateCount(count+1) }, modifier = Modifier.padding(24.dp)) {
        Text(text = "The button has been clicked $count times")
    }
}