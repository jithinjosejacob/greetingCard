package com.example.greetingcard

import android.content.Intent
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.rotationMatrix
import com.example.greetingcard.ui.theme.GreetingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BirthdayGreetingWithText(message = "Happy Birthday Suraj!", from = "dumel")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(message: String,from: String) {

        Column {
            Text(text = message, fontSize = 36.sp
                , modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.Start)
                    .padding(start = 16.dp, top = 16.dp)
            )
            Text(text = from,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.End)
                    .padding(start = 16.dp, end = 16.dp))
            LoginScreen()
        }

   
}



@Composable
fun LoginScreen() {
    val context = LocalContext.current
    Button(onClick = { context.startActivity(Intent(context,LoginActivity::class.java)) } ) {
        Text(text = "Login")
    }
}
@Composable

fun BirthDayGreetingWithImage(message:String , from: String) {

    val image = painterResource(id = R.drawable.androidparty)
    Box{
        Image(painter = image, contentDescription = null, modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(), contentScale = ContentScale.Crop)
        BirthdayGreetingWithText(message = message, from = from)

    }


}


@Preview(showBackground = true)
@Composable
fun BirthdayGreetingWithImagePreview() {
    GreetingCardTheme {
        BirthDayGreetingWithImage(message= stringResource(R.string.happy_birthday_text), from = stringResource(
                    R.string.from)
                )
    }
}