package com.example.login

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          LoginUi()
        }
    }
}

@Composable
fun LoginUi(){

    LoginScreen()
}

@Composable
fun LoginScreen(){
    var context = LocalContext.current
    var username by remember{
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.little_logo), contentDescription ="logo", modifier = Modifier.padding(10.dp) )
        TextField(value = username, onValueChange = { newTxt -> username = newTxt}, label = { Text(text = "Username")},modifier = Modifier.padding(10.dp))
        TextField(value = password, onValueChange = { newTxt -> password = newTxt}, label = { Text(text = "Password")},modifier = Modifier.padding(10.dp))
        Button(onClick = {
            if (username == "Darian" && password == "littlelemon"){
                Toast.makeText(context,"granted",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context,"false",Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Login")
        }
    }

}



