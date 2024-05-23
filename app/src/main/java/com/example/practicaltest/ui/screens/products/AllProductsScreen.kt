package com.example.practicaltest.ui.screens.products

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.practicaltest.R
import com.example.practicaltest.core.api.Post
import com.example.practicaltest.core.util.Screens
import com.example.practicaltest.ui.components.ProductCard
import com.example.practicaltest.ui.components.SearchField

@Composable
fun AllProductScreen(
    navController: NavController,
    viewModel: AllProductsScreenViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchProduct()
    }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    AllProductsScreenContent(
        uiState = uiState,
        navigateToProductScreen = {
            navController.navigate(Screens.PRODUCT_SCREEN + "/${it}")
        }
    )

}

@Composable
fun AllProductsScreenContent(
    uiState: AllProductsScreenState,
    navigateToProductScreen: (String) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
                    .background(Color.White),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(onClick = { /* Handle click event here */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.user), // Replace with your icon resource
                        contentDescription = "user"
                    )
                }

                Text(
                    text = "Hello userName",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )


                IconButton(onClick = { /* Handle click event here */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.logout), // Replace with your icon resource
                        contentDescription = "logout"
                    )
                }
            }
        }
    ) { _ ->

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Row(
                modifier = Modifier
                    .background(Color(0xFF68AB00))
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {


                Text(
                    text = "15% off if you pay via MCoopCash!",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .background(Color(0xFF68AB00))
                )
            }

            Row(modifier = Modifier.height(100.dp).fillMaxWidth().background(Color(0xFF68AB00)),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "15% off if you pay via MCoopCash!", style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .padding(8.dp)
                )
            }


            SearchField(
                onValueChange = {}
            )

            Spacer(modifier = Modifier.height(8.dp))


            Row {
                Text(
                    text = "Best Selling", style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier,
            ) {
                items(items = uiState.posts) { item ->
                    ProductCard(
                        image = R.drawable.login,
                        title = item.title,
                        price = item.body.take(10),
                        modifier = Modifier.padding(4.dp),
                        onClick = {
                            navigateToProductScreen(item.id.toString())
                        }
                    )
                }
            }

        }
    }

}

val items = (1..10).map {
    Post(
        title = "Item 1",
        id = it,
        body = "Body ${it}",
        userId = it
    )
}

@Preview
@Composable
fun AllProductsScreenPreview() {
    AllProductsScreenContent(
        uiState = AllProductsScreenState(posts = items),
        navigateToProductScreen = {}
    )
}