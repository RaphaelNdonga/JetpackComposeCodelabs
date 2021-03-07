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
            MyApp{
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
fun MyScreenContent(nameList:List<String> = listOf("Raphael","Linus","John","Joy")){
    Column{
        for(name in nameList){
            Greeting(name = name)
            Divider(color = Color.Black)
        }
        Text(text = "The total number of people is ${nameList.size}",modifier = Modifier.padding(24.dp))
        Divider(color = Color.Black)
        Counter()
    }
}

@Composable
fun Counter(){
    /**
     *     mutableStateOf is how to create mutable memory in a composable function.
     *     Why can't we use a normal variable?
     *     Because composable functions by default are not meant to remember anything. They just
     *     render the UI.
     */
    val counter = remember{ mutableStateOf(0) }
    /**
     * the counter value is only changed onClick.  onClick runs on the main thread, so threading
     * issues will not be encountered.
     */
    Button(onClick = { ++counter.value },modifier = Modifier.padding(24.dp)){
        Text(text = "The button has been clicked ${counter.value} times")
    }
}