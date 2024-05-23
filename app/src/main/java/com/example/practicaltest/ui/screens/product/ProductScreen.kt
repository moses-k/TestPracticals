package com.example.practicaltest.ui.screens.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController

@Composable
fun ProductScreen(
    id:String,
    navController: NavController,
    viewModel: ProductScreenViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    LaunchedEffect(key1 = Unit) {
        viewModel.getProductById()
    }
    ProductScreenContent(uiState = uiState, id = id)

}

@Composable
fun ProductScreenContent(uiState: ProductScreenState,id: String){
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { _ ->
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text ="ID >>>" + id)
        }
    }

}