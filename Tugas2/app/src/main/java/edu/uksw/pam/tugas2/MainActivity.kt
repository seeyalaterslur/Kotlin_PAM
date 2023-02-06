package edu.uksw.pam.tugas2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.uksw.pam.tugas2.ui.theme.Tugas2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tugas2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginForm()
                }
            }
        }
    }
}

internal fun doAuth(
    username: String,
    password: String,
):Boolean{
    return (username.equals("admin") && password.equals("admin"))
}

@Composable
fun LoginForm(){
    val lContext = LocalContext.current

    var usernameInput by remember {
        mutableStateOf("")
    }
    var passwordInput by remember {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)

    ) {
        TextField(
            value = usernameInput.toString(),
            onValueChange = {usernameInput = it},
            label = { Text(text = "Username") },
            modifier = Modifier
                .fillMaxWidth(),
        )
        TextField(
            value = passwordInput.toString(),
            onValueChange = {passwordInput = it},
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth(),
        )
        Button(onClick = {
            val isAuthtenticated = doAuth(usernameInput, passwordInput)
            if (isAuthtenticated) {
                lContext.startActivity(
                    Intent(lContext, HomeActivity::class.java)
                        .apply {
                            putExtra("username", usernameInput)
                        }
                )
            }
        }
        )
        {
            Text(text = "Login")
        }
    }
}

@Preview(showBackground = true)

@Composable
fun LoginFormPreview() {
    Tugas2Theme() {
        LoginForm()
    }
}