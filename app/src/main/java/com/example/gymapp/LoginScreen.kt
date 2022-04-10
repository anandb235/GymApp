package com.example.gymapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.cos

@Composable
fun LoginScreen() {
    val userName = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFFD2ABB2),
                        Color(0xFFC63F6A)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .clip(RoundedParallelogram())
                .background(Color.White)
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 25.dp, vertical = this.maxHeight / 6),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Hello !",
                    fontFamily = comfortaa,
                    fontSize = 20.sp,
                    color = Color(0xFFBF0B4C),
                    fontWeight = FontWeight.Bold
                )
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = userName.value,
                    onValueChange = {
                        userName.value = it
                    },
                    placeholder = {
                        Text(
                            "Username",
                            fontFamily = comfortaa,
                            fontWeight = FontWeight.Normal,
                            fontSize = 19.sp
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                        )
                    },
                    textStyle = TextStyle(
                        fontFamily = comfortaa,
                        fontWeight = FontWeight.Normal,
                        fontSize = 19.sp
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color(0xFF0E0E0E),
                        leadingIconColor = Color(0xFFBF0B4C),
                        focusedIndicatorColor = Color(0xFFBF0B4C),
                        unfocusedIndicatorColor = Color.Gray,
                        placeholderColor = Color.Gray,
                        backgroundColor = Color.Transparent

                    )

                )
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = password.value,
                    onValueChange = {
                        password.value = it
                    },
                    placeholder = {
                        Text(
                            "Password",
                            fontFamily = comfortaa,
                            fontWeight = FontWeight.Normal,
                            fontSize = 19.sp
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = null,
                        )
                    },
                    textStyle = TextStyle(
                        fontFamily = comfortaa,
                        fontWeight = FontWeight.Normal,
                        fontSize = 19.sp
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color(0xFF0E0E0E),
                        leadingIconColor = Color(0xFFBF0B4C),
                        focusedIndicatorColor = Color(0xFFBF0B4C),
                        unfocusedIndicatorColor = Color.Gray,
                        placeholderColor = Color.Gray,
                        backgroundColor = Color.Transparent
                    )
                )

                Text(
                    "Forgot Password?",
                    fontFamily = comfortaa,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                Text(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .clip(CircleShape)
                        .background(Color(0xFFBF0B4C))
                        .padding(15.dp),
                    text = "Login",
                    fontFamily = comfortaa,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

        }
        Text(
            "No Account? Sign Up",
            fontFamily = comfortaa,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

class RoundedParallelogram : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val topRadius = with(density) { 20.dp.toPx() }
        return Outline.Generic(
            path = Path().apply {
                reset()
                arcTo(
                    rect = Rect(
                        left = 0f,
                        top = 0f,
                        right = 2 * topRadius,
                        bottom = 2 * topRadius
                    ),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 110f,
                    forceMoveTo = false
                )
                lineTo(size.width - topRadius, size.height / 5f)
                arcTo(
                    rect = Rect(
                        left = size.width - 2 * topRadius,
                        top = size.height / 5f,
                        right = size.width,
                        bottom = size.height / 5f + 2 * topRadius
                    ),
                    startAngleDegrees = 270f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )
                lineTo(size.width, size.height - 2 * topRadius)
                arcTo(
                    rect = Rect(
                        left = size.width - 2 * topRadius,
                        top = size.height - 2 * topRadius,
                        right = size.width,
                        bottom = size.height
                    ),
                    startAngleDegrees = 0f,
                    sweepAngleDegrees = 110f,
                    forceMoveTo = false
                )
                lineTo(topRadius, 4 * size.height / 5f)
                arcTo(
                    rect = Rect(
                        left = 0f,
                        top = 4 * size.height / 5f - 2 * topRadius,
                        right = 2 * topRadius,
                        bottom = 4 * size.height / 5f
                    ),
                    startAngleDegrees = 90f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )
                close()
            }
        )
    }
}

val comfortaa = FontFamily(
    listOf(
        Font(R.font.comfortaa_regular, FontWeight.Normal),
        Font(R.font.comfortaa_medium, FontWeight.Medium),
        Font(R.font.comfortaa_semibold, FontWeight.SemiBold),
        Font(R.font.comfortaa_bold, FontWeight.Bold),
        Font(R.font.comfortaa_light, FontWeight.Light)
    )
)