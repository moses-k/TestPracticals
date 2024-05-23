package com.example.practicaltest.ui.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicaltest.core.util.Screens
import com.example.practicaltest.ui.screens.login.LoginScreen
import com.example.practicaltest.ui.screens.product.ProductScreen
import com.example.practicaltest.ui.screens.products.AllProductScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.LOGIN_SCREEN,
    ) {
        composable(route = Screens.LOGIN_SCREEN,) {
            LoginScreen(navController = navController)
        }
        composable(route = Screens.PRODUCT_SCREEN + "/{id}") {
            val id = it.arguments?.getString("id") ?:""
            ProductScreen(navController = navController,id = id)
        }
        composable(route = Screens.ALL_PRODUCTS_SCREEN) {
            AllProductScreen(navController = navController)
        }
    }

}