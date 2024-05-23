package com.example.practicaltest.ui.screens.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.practicaltest.dataclass.Post
import com.example.practicaltest.ui.components.ProductCard
import com.example.practicaltest.util.Screens
import com.example.practicaltest.ui.components.SearchField

data class Product(val name: String, val price: String, val imageRes: Int)


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
            navController.navigate("product-screen" + "/${it}")
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
    ) { it->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp)
            .padding(it)) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF4CAF50))
                .padding(16.dp)
        ) {
            Text(
                text = "15% off if you pay via MCoopCash!",
                color = Color.White,
                //style = MaterialTheme.typography.body1
            )
        }

        // Search Bar
            var searchText by remember { mutableStateOf("") }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                SearchField(
                    onValueChange = {}
                )
            }


            Row {
                Text(
                    text = "Best Selling", style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp)

                )
            }

            // Best Selling Products Grid
            val products = listOf(
                Product("Traveling Bag", "KES 600.00", R.drawable.image_1),
                Product("Carrier Bag", "KES 50.00", R.drawable.image_9),
                Product("Puffer Jacket", "KES 1,800.00", R.drawable.image_7),
                Product("Polo Shirt", "KES 400.00", R.drawable.image_10)
                // Add more products as needed
            )

            LazyColumn(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                itemsIndexed(products.chunked(2)) { index, rowItems ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        for (product in rowItems) {
                            ProductCard(
                                product,
                                onClick = { navigateToProductScreen(product.name) }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

//            LazyVerticalGrid(
//                columns = GridCells.Fixed(2),
//                modifier = Modifier,
//            ) {
//                items(items = uiState.posts) { item ->
//                    ProductCard(
//                        image = "https://picsum.photos/200/30${item.id}",
//                        title = item.title,
//                        price = item.body.take(10),
//                        modifier = Modifier.padding(4.dp),
//                        onClick = {
//                            navigateToProductScreen(item.id.toString())
//                        }
//                    )
//                }
//            }
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
@Composable
fun ProductCard(product: Product,
    onClick:() -> Unit,
    ) {

    Column(
        modifier = Modifier
            .width(154.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(8.dp)
            .clickable(onClick = onClick)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .size(200.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = product.name,
            //  style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = product.price,
            //  style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
    }
}

@Preview
@Composable
fun AllProductsScreenPreview() {
    AllProductsScreenContent(
        uiState = AllProductsScreenState(posts = items),
        navigateToProductScreen = {}
    )
}