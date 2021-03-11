package com.example.intrinsics

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.intrinsics.ui.theme.IntrinsicsTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntrinsicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TwoTextDivided(text1 = "Hi", text2 = "There")
                }
            }
        }
    }
}

/**
 * Intrinsics are used to acquire the measurements of the children before we use those measurements.
 * It is one of the special cases whereby children can be measured more than once. I think this is
 * because at compile time, we already know definitively the size of the children unlike using
 * measurables whereby the values are obtained at runtime.
 */
@Composable
fun TwoTextDivided(modifier: Modifier = Modifier, text1: String, text2: String) {
    Row(modifier = modifier.height(IntrinsicSize.Min)) {
        Text(
            text = text1, modifier = Modifier
                .weight(1f)
                .wrapContentWidth(Alignment.Start)
                .padding(start = 4.dp)
        )
        Divider(color = Color.Black, modifier = Modifier.fillMaxHeight().width(1.dp))
        Text(text = text2, modifier = Modifier
            .weight(1f)
            .wrapContentWidth(Alignment.End)
            .padding(end = 4.dp))
    }
}
@Preview("Two Texts Divided Preview")
@Composable
fun TwoTextsDividedPreview(){
    TwoTextDivided(text1 = "Hi" , text2 = "There" )
}