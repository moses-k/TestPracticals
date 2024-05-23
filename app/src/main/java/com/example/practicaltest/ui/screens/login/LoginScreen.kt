package com.example.practicaltest.ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.practicaltest.R
import com.example.practicaltest.core.util.Screens
import com.example.practicaltest.ui.components.CustomInputField
import com.example.practicaltest.ui.components.GreenButton
import com.example.practicaltest.ui.components.LoginInputField

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginScreenViewModel = hiltViewModel()
) {


    LoginScreenContent(
        navigateToAllProductsScreen = {
            navController.navigate(Screens.ALL_PRODUCTS_SCREEN)
        }
    )


}

@Composable
fun LoginScreenContent(
    navigateToAllProductsScreen:() -> Unit,
) {
    val userName = rememberSaveable{ mutableStateOf("MB30123456") }
    val password = rememberSaveable { mutableStateOf("* * * * * * * *") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.login),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.8f),
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .fillMaxHeight(0.8f),
                        contentScale = ContentScale.Crop
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Welcome to a New Banking Experience",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.5f),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Dream it. Achieve it.",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }


        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Already registered on the new platform?",
                    style = TextStyle(
                        color = Color(0xFF535353),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Use your credentials to log in",
                    style = TextStyle(
                        color = Color(0xFF4F4F50),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(.9f)
                    .padding(
                        start = 0.dp,
                        top = 0.dp,
                        end = 0.dp,
                        bottom = 0.dp
                    )
                ) {

                Spacer(modifier = Modifier.height(10.dp))


                CustomInputField(
                    inputTitle = "UserName",
                    inputValue = userName.value,
                    labelColor = Color.White,
                    textColor = Color(0xFF68AB00),
                    keyboardType = KeyboardType.Text,
                    setValue = {
                        userName.value  =it
                    },
                    readOnly = false
                )
                Text(
                    text = "Forgot Username",
                    modifier = Modifier
                        .wrapContentSize(),
                    style = TextStyle(
                        color = Color(0xFF68AB00),
                        fontSize = 15.sp,
                        textAlign = TextAlign.Right,
                    )
                )

                CustomInputField(
                    inputTitle = "Password",
                    inputValue = password.value,
                    labelColor = Color.White,
                    textColor = MaterialTheme.colorScheme.primary,
                    keyboardType = KeyboardType.Text,
                    setValue = {
                        password.value = it
                    },
                    readOnly = false
                )
                Text(
                    text = "Forgot Password",
                    modifier = Modifier
                        .wrapContentSize(),
                    style = TextStyle(
                        color = Color(0xFF68AB00),
                        fontSize = 15.sp,
                        textAlign = TextAlign.Right,
                    )
                )

                GreenButton(
                    text = "Login",
                    onClick = navigateToAllProductsScreen

                )
            }

        }
    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreenContent(navigateToAllProductsScreen = {})
}