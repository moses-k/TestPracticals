package com.example.practicaltest.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GreenButton(text: String, enabled: Boolean = true, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .height(75.dp)
            .padding(
                start = 0.dp,
                top = 15.dp,
                end = 0.dp,
                bottom = 10.dp
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF68AB00),
            disabledContainerColor = Color(0xFF68AB00)
        ),
        shape = RoundedCornerShape(10),
        contentPadding = ButtonDefaults.ContentPadding,
        enabled = enabled

    ) {
        Text(
            style = TextStyle(
                color = Color.White,
                fontSize = 17.sp,

                ),
            text = text
        )
    }
}
