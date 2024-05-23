package com.example.practicaltest.ui.screens.product

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.practicaltest.R
import com.example.practicaltest.dataclass.Post
import com.example.practicaltest.ui.components.GreenButton

data class Product(val name: String, val price: String, val imageRes: Int)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsScreen(
    id: String,
    navController: NavController,
    viewModel: ProductScreenViewModel = hiltViewModel()
    ) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    LaunchedEffect(key1 = Unit) {
        //viewModel.getProductById()
    }
    ProductScreenContent(uiState = uiState, id = id)
}

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    fun ProductScreenContent(uiState: ProductScreenState, id: String) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Traveling Bag") },
                    navigationIcon = {
                        IconButton(onClick = { /* Handle back action */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_arrow_back), // replace with your back icon
                                contentDescription = "Back"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* Handle close action */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_close), // replace with your close icon
                                contentDescription = "Close"
                            )
                        }
                    }
                )
            }
        ) {

            uiState.product?.let { post ->

                Column(modifier = Modifier.padding(16.dp)) {
//                Image(
//                    painter = painterResource(id = R.drawable.image_1), // replace with your product image
//                    contentDescription = "Traveling Bag",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(200.dp)
//                        .background(Color.LightGray, RoundedCornerShape(8.dp)),
//                    contentScale = ContentScale.Crop
//                )

                    AsyncImage(
                        model = "https://picsum.photos/200/30${post.id}",
                        contentDescription = "items",
                        modifier = Modifier
                            .width(400.dp)
                            .height(400.dp)
                            .padding(top = 16.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Traveling Bag",
                        //style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 4.dp)
                    ) {
                        Text(
                            text = "600.00 KES",
                            // style = MaterialTheme.typography.h6,
                            color = Color(0xFF4CAF50), // Use your desired color
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "VAT Inclusive",
                            // style = MaterialTheme.typography.body2,
                            color = Color.Gray
                        )
                    }

                    Text(
                        text = "Apparel",
                        //style = MaterialTheme.typography.body2,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    Text(
                        text = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight ...",
                        //style = MaterialTheme.typography.body2,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    TextButton(onClick = { /* Handle see more action */ }) {
                        Text(
                            text = "see more",
                            color = Color(0xFF4CAF50) // Use your desired color
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    GreenButton(
                        text = "Add To Cart",
                        onClick = {

                        }

                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Best Selling",
                        //   style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp)
                    ) {
                        val products = listOf(
                            Product("Traveling Bag", "KES 600.00", R.drawable.image_10),
                            Product("Carrier Bag", "KES 50.00", R.drawable.image_7),
                            Product("Puffer Jacket", "KES 1,800.00", R.drawable.image_11),
                            Product("Polo Shirt", "KES 400.00", R.drawable.image_9)
                            // Add more products as needed
                        )

                        items(products.size) { index ->
                            ProductCard(products[index])
                        }
                    }
                }

            }


        }
    }



@Composable
fun ProductCard(product: Product) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .background(Color.LightGray, RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = product.name,
           // style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = product.price,
         //   style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
    }
}

//fun ProductDetailsScreenPreview() {
//    ProductDetailsScreen(navController = rememberNavController(),1)
//}

@Preview
@Composable
fun ProductScreenPreview() {
    ProductScreenContent(
        uiState = ProductScreenState(
            product = Post(
                body = "1234",
                id = 1,
                title = "33333",
                userId = 1
            )
        ), id = "1"
    )
}