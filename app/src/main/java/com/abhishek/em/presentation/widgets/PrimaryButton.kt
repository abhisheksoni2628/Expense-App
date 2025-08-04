package com.abhishek.em.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhishek.em.R


@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit
) {


    val oswald = FontFamily(
        Font(R.font.oswald_medium, FontWeight.Normal)
    )

    Box(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onClick() }
            .background(Color(0xFF131313), shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 32.dp, vertical = 16.dp)
            .shadow(
                elevation = 24.dp,
                shape = RoundedCornerShape(16.dp),
                ambientColor = Color(0xFF7500FF),
                spotColor = Color(0xFF7500FF)
            )
    ) {
        Text(
            text = text.uppercase(),
            color = Color.White,
            fontFamily = oswald,
            fontSize = 18.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    PrimaryButton("Save", {

    })
}