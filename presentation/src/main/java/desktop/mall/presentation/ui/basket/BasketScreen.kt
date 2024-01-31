package desktop.mall.presentation.ui.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import desktop.mall.domain.model.BasketProduct
import desktop.mall.domain.model.Product
import desktop.mall.presentation.R
import desktop.mall.presentation.ui.component.Price
import desktop.mall.presentation.ui.theme.Purple40
import desktop.mall.presentation.utils.NumberUtils
import desktop.mall.presentation.viewmodel.BasketViewModel

@Composable
fun BasketScreen(viewModel: BasketViewModel = hiltViewModel()) {
    val basketProducts by viewModel.basketProducts.collectAsState(initial = listOf())
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(basketProducts.size) { index ->
                BasketProductCard(basketProduct = basketProducts[index]) {
                    viewModel.removeBasketProduct(it)
                }
            }
        }
        
        Text(text = "총 ${getTotalPrice(basketProducts)} 원")
        
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Purple40
            )
        ) {
            Text(text = "구매하기")
        }
    }
}

@Composable
fun BasketProductCard(basketProduct: BasketProduct, removeProduct: (Product) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        IconButton(
            onClick = { removeProduct(basketProduct.product) },
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(
               Icons.Filled.Close,"description"
            )
        }
        
        Row {
            Image(
                painter = painterResource(id = R.drawable.product_image), 
                contentDescription = "description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(120.dp)
                    .aspectRatio(1f)
            )
            Column {
                Text(
                    text = basketProduct.product.productName
                )
                Text(
                    text = basketProduct.product.category.categoryName
                )
            }
        }
        
        Price(product = basketProduct.product)
        
        Text(text = "${basketProduct.count} 개")
    }
}

private fun getTotalPrice(list: List<BasketProduct>): String {
    val totalPrice = list.sumOf { it.product.price.finalPrice * it.count }
    return NumberUtils.numberFormatPrice(totalPrice)
}