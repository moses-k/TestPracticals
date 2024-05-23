package com.example.practicaltest.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicaltest.R

@SuppressLint("UnrememberedMutableState")
@Composable
fun CustomInputField(
    inputTitle: String,
    inputValue: String,
    keyboardType: KeyboardType,
    errorMessage: String? = null,
    indicator: Boolean = true,
    readOnly: Boolean = false,
    shouldCapitalize: Boolean = false,
    labelColor: Color = Color.White,
    textColor: Color = Color.White,
    setValue: (String) -> Unit,

    ) {
    val colors = TextFieldDefaults.colors(
        errorTextColor = Color.Red,
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,
        errorContainerColor = Color.Transparent,
        errorCursorColor = Color.Red,
        focusedIndicatorColor = if (indicator) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.scrim,
        unfocusedIndicatorColor = if (indicator) MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.scrim,
        errorIndicatorColor = Color.Red,
        errorLeadingIconColor = Color.Red,
        errorTrailingIconColor = Color.Red,
        errorLabelColor = Color.Red,
        errorPlaceholderColor = Color.Red,
        disabledIndicatorColor = Color.Transparent

    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

//        Text(
//            text = inputTitle,
//            modifier = Modifier
//                .wrapContentSize(),
//            style = TextStyle(
//                //color = Color(0xFF68AB00),
//                fontSize = 15.sp,
//                textAlign = TextAlign.Right,
//            )
//        )
        Text(text = inputTitle)

        TextField(
            // value = if(inputValue.isNullOrEmpty()) "---" else inputValue ,
            value = inputValue,
            onValueChange = setValue,
            readOnly = readOnly,
            modifier = Modifier
                .background(Color.Transparent)
                .padding(
                    top = 0.dp, // 0dp to remove, adjust as needed
                    bottom = 0.dp,
                    start = 0.dp,
                    end = 0.dp
                ),
            isError = errorMessage != null,
            supportingText = {
                if (errorMessage != null) {
                    InputFieldErrorText(errorMessage = errorMessage)
                }else{
                    TextButton(onClick = { /* Handle forgot username */ }) {
                        Text(text = "Forgot Username?", )
                    }
                }
            },
            label = {
                Text(
                    modifier = Modifier
                        .padding(top = 0.dp),//.offset(-17.dp),
                    text = inputTitle,
                    style = TextStyle(
                        color = if(inputValue.isNullOrEmpty()) Color.Red else labelColor,
                        fontSize = 12.sp,
                        //fontFamily = FontFamily(Font(R.font.nunitosans_7pt_regular))
                    ),
                    maxLines = 1,
                )
            },
            colors = colors,
            singleLine = true,
            visualTransformation = VisualTransformation.None,
            shape = RectangleShape,
            maxLines = 1,
            textStyle = TextStyle(
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                color =textColor

            ),
            keyboardOptions = KeyboardOptions(
                capitalization = if (shouldCapitalize) KeyboardCapitalization.Characters else KeyboardCapitalization.Sentences,
                autoCorrect = false,
                keyboardType = keyboardType,
                imeAction = ImeAction.Next
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginInputField(
    label: String,
    inputValue: String,
    onChangeValue: (String) -> Unit,
    errorMessage: String? = null,
    indicator: Boolean = true,

    ) {
    val colors = TextFieldDefaults.colors(
        errorTextColor = Color.Red,
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,
        errorContainerColor = Color.Transparent,
        errorCursorColor = Color.Red,
        focusedIndicatorColor = if (indicator) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.scrim,
        unfocusedIndicatorColor = if (indicator) MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.scrim,
        errorIndicatorColor = Color.Red,
        errorLeadingIconColor = Color.Red,
        errorTrailingIconColor = Color.Red,
        errorLabelColor = Color.Red,
        errorPlaceholderColor = Color.Red,
        disabledIndicatorColor = Color.Transparent

    )
    TextField(
        colors = colors,
        value = inputValue,
        textStyle = TextStyle(
            fontSize = 17.sp,
            textAlign = TextAlign.Left,
            color = MaterialTheme.colorScheme.secondary,

            //fontFamily = FontFamily(Font(R.font.nunitosans_7pt_regular)),


            ),
        isError = errorMessage != null,
        label = {
            if (inputValue.isEmpty() || errorMessage == null) {
                Text(
                    text = label,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 15.sp,
                        //fontFamily = FontFamily(Font(R.font.nunitosans_7pt_regular)),

                        ),
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .offset(y = (-10).dp)
                        .offset(x = (-20).dp)
                )
            } else {
                Text(
                    text = errorMessage,
                    style = TextStyle(
                        color = Color.Red,
                        fontSize = 15.sp,
                        //fontFamily = FontFamily(Font(R.font.nunitosans_7pt_regular)),

                        ),
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .offset(y = (-10).dp)
                        .offset(x = (-20).dp)

                )
            }
        },
        onValueChange = onChangeValue,
        modifier = Modifier
            .background(Color.Transparent)
            .padding(
                top = 0.dp, // 0dp to remove, adjust as needed
                bottom = 0.dp,
                start = 0.dp,
                end = 0.dp
            )
        ,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = false,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        shape = RectangleShape,
        maxLines = 1,
        singleLine = true
    )
}
@Composable
fun InputFieldErrorText(errorMessage: String) {
    Text(
        text = errorMessage,
        style = TextStyle(
            color = Color.Red,
            fontSize = 12.sp,
            //fontFamily = FontFamily(Font(R.fo))
        ),
        modifier = Modifier
            .padding(0.dp, 5.dp, 0.dp, 5.dp)

    )
}