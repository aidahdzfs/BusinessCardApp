package com.example.businesscardapp

import android.media.Image
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp (){
    Column (
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Profile(
            image = painterResource(R.drawable.aida),
            name = stringResource(R.string.name),
            title = stringResource(R.string.title)
        )
        Spacer(Modifier.height(80.dp))
        Contact(
            callIcon = painterResource(R.drawable.baseline_call_24),
            sosmedIcon = painterResource(R.drawable.linkedin),
            emailIcon = painterResource(R.drawable.baseline_email_24),
            number = stringResource(R.string.number),
            sosmed = stringResource(R.string.sosmed),
            email = stringResource(R.string.email)
        )
    }
}

@Composable
private fun Profile (image: Painter, name: String, title: String, modifier: Modifier = Modifier){
    Column (
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
            ){
        Image(
            painter = image,
            contentDescription = null,
            Modifier
                .size(150.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = name,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = title,
            fontSize = 20.sp,
        )
    }

}

@Composable
private fun Contact (callIcon: Painter, sosmedIcon: Painter, emailIcon: Painter, number: String, sosmed: String, email: String,modifier: Modifier = Modifier){
    Column (Modifier){
        Row (Modifier.padding(5.dp)){
            Icon(painter = callIcon, contentDescription = null, tint = Color.Blue)
            Spacer(Modifier.width(5.dp))
            Text(text = number)
        }
        Row (Modifier.padding(5.dp)){
            Image(painter = sosmedIcon, contentDescription = null, Modifier.size(24.dp))
            Spacer(Modifier.width(5.dp))
            Text(text = sosmed)
        }
        Row (Modifier.padding(5.dp)){
            Icon(painter = emailIcon, contentDescription = null, tint = Color.Blue)
            Spacer(Modifier.width(5.dp))
            Text(text = email)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}