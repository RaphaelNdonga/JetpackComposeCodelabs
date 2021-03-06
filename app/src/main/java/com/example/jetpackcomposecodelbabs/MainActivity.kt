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
            MyApp()
        }
    }
}

/**
 * Notice that the composable function is outside MainActivity class. This is to allow for code
 * re-usability and sharing.
 */
@Composable
fun MyApp() {
    JetpackComposeCodelbabsTheme {
        /**
         * To change the color of a composable, you have to define a surface that contains it
         */
        Surface(color = Color.Yellow) {
            Greeting("Raphael")
        }
    }
}

@Composable
fun Greeting(name: String) {
        /**
         * A modifier is used to tell the UI elements how to display, layout and behave while
         * within the parent layout.
         */
        Text(text = "Hello $name!",modifier = Modifier.padding(24.dp))

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}