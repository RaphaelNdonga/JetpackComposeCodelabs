package com.example.jetpackcomposecodelbabs

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
                Greeting(name = "Raphael")
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

@Preview("Text Preview")
@Composable
fun DefaultPreview() {
    MyApp {
        Greeting(name = "Raphael")
    }
}