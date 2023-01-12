package com.example.myapplicationcompose

import android.os.Bundle
import android.text.style.ClickableSpan
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationcompose.ui.theme.MyApplicationComposeTheme
import com.example.myapplicationcompose.ui.theme.Purple700


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginDesign()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationComposeTheme {
        LoginDesign()
    }


}

@Composable
fun LoginDesign(){
    var emailValue by remember {
        mutableStateOf("")
    }
    var passwordValue by remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier
        .fillMaxSize()
    ){
        _ClickableText(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            text = "Sign Up?",
            16.sp,
            onClick = {

            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),

        ) {
            _SpacerFR(0.3f)
            Text(
                text = "Login",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Cursive,
                )
            )
            _SpacerDP(10.dp)
            _OutlinedTextField(
                hint = "Please Enter You Email",
                text = emailValue, callback = {
                emailValue = it
               }
            )
            _SpacerDP(10.dp)
            _OutlinedTextField(hint = "Please Enter Your Password", text = passwordValue) {
                passwordValue=it
            }
            _SpacerDP(10.dp)
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                _ClickableText(
                    text = "Sign Up?",
                    fontSize = 16.sp,
                   onClick =  {

                    }
                )
            }
            _SpacerDP(20.dp)
            Button(

                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(50.dp),
                onClick = { /*TODO*/ }) {
                Text(
                    "Submit",
                    style = TextStyle(
                        color = Color.White,
                        fontSize =18.sp,
                        fontFamily = FontFamily.Cursive
                    )
                )

            }

        }
        
        
    }
}

@Composable
fun _ClickableText(modifier: Modifier =Modifier, text: String, fontSize: TextUnit, onClick: () -> Unit) {
    ClickableText(
        modifier = modifier,
        text = AnnotatedString(text),
        onClick = {
            onClick.invoke()
        },
        style = TextStyle(
            textDecoration = TextDecoration.Underline,
            fontFamily = FontFamily.Cursive,
            fontSize = fontSize
        ),
    )
}
@Composable
fun _OutlinedTextField(
    hint: String,
    text: String,
    callback: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = {
            callback(it)
        },
        label = {
            Text(hint)
        },
        singleLine = true,
    )
}
@Composable fun _SpacerDP(dp:Dp){
    Spacer(
        modifier = Modifier.height(10.dp)
    )
}
@Composable fun _SpacerFR(dp:Float){
    Spacer(
        modifier = Modifier
            .fillMaxHeight(dp)
            .fillMaxWidth()
    )
}
