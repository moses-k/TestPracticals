package com.example.practicaltest.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
    onValueChange: (String) -> Unit
) {

    val usernameValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 12.dp)
            .padding(vertical = 4.dp, horizontal = 10.dp),
        value = usernameValue.value ,
        onValueChange = {
            usernameValue.value = it
            onValueChange(it)
        },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Black)
        },
        trailingIcon = {
            Icon(Icons.Default.List, contentDescription = "Search", tint = Color.Black)
        },
        label = { Text(text = "Search products") },
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
        ),
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        ),
        keyboardOptions = KeyboardOptions.Default,


        )

}