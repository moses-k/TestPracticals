package com.example.practicaltest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.practicaltest.ui.screens.login.LoginScreen
import com.example.practicaltest.ui.screens.product.ProductDetailsScreen
import com.example.practicaltest.ui.screens.products.AllProductScreen

@Composable
fun AppNavigation(initialRoute: String,navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = initialRoute,
    ) {
        composable("login") { LoginScreen(navController) }
        composable("all-products") { AllProductScreen(navController) }
        composable("product-screen/{param}") {
            val id = it.arguments?.getString("id") ?:""
            ProductDetailsScreen(navController = navController,id = id)
           // ProductDetailsScreen(navController = navController)
        }
    }

}