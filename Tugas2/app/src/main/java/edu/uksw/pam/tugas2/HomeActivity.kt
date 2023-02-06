package edu.uksw.pam.tugas2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.uksw.pam.tugas2.ui.theme.Tugas2Theme

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tugas2Theme() {
                // A surface container using the 'background' color from the theme
                Surface(

                ) {
//                    val username = getIntent().getStringExtra("username") ?: ""

                    Title()
                    LandingPage()
                    ContentAnime()
                    Content()
                }
            }
        }
    }
}

@Composable
fun Title(){
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "LIVE",
            modifier = Modifier,
            fontWeight = FontWeight.W800,
            fontFamily = FontFamily.SansSerif,
            )
        Text(text = "For You",
            modifier = Modifier,
            fontWeight = FontWeight.W800,
            fontFamily = FontFamily.SansSerif,
        )
        Text(text = "Anime",
            modifier = Modifier,
            fontWeight = FontWeight.W800,
            fontFamily = FontFamily.SansSerif,
        )
        Text(text = "Anime+",
            modifier = Modifier,
            fontWeight = FontWeight.W800,
            fontFamily = FontFamily.SansSerif,
        )
        Text(text = "Gaming",
            modifier = Modifier,
            fontWeight = FontWeight.W800,
            fontFamily = FontFamily.SansSerif,
        )
    }
}

@Composable
fun LandingPage(
){
    Card(
        modifier = Modifier
            .padding(20.dp,50.dp,20.dp,20.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp),
    ) {
        Image(painter = painterResource(id = R.drawable.test),
            contentDescription =null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .size(150.dp)

        )
    }

    Text(text = "The Ice blade Sorcerer Shall Rule the World",
        fontWeight = FontWeight.W500,
        color = Color.Black,
        fontFamily = FontFamily.SansSerif,
        modifier = Modifier
            .padding(20.dp,210.dp)
    )
}

@Composable
fun ContentAnime(
){
    Text(text = "Anime",
        modifier = Modifier
            .padding(20.dp,250.dp),
        fontWeight = FontWeight.W800,
        fontFamily = FontFamily.SansSerif,
    )
}

@Composable
fun Content(){
    Row(
        modifier = Modifier
            .padding(0.dp,270.dp)
    ) {
        Box(
            modifier = Modifier
        ) {
            Card(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.haikyu),
                    contentDescription =null,
                    modifier = Modifier.requiredSize(150.dp))
            }
        }
    }

    Row(
        modifier = Modifier
            .padding(150.dp,270.dp)
    ) {
        Box(
            modifier = Modifier
        ) {
            Card(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.anim),
                    contentDescription =null,
                    modifier = Modifier.requiredSize(150.dp))
            }
        }
    }

}


@Preview(showBackground = true)

@Composable
fun LandingPagePreview() {
    Tugas2Theme {
        Title()
        LandingPage()
        ContentAnime()
        Content()
    }
}