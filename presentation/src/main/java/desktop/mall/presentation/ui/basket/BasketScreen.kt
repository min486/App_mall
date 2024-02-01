package desktop.mall.presentation.ui.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import desktop.mall.domain.model.BasketProduct
import desktop.mall.domain.model.Product
import desktop.mall.presentation.R
import desktop.mall.presentation.ui.theme.GrayIcon
import desktop.mall.presentation.ui.theme.GrayLine
import desktop.mall.presentation.ui.theme.GrayLine2
import desktop.mall.presentation.ui.theme.GrayText
import desktop.mall.presentation.ui.theme.basketPrice
import desktop.mall.presentation.utils.NumberUtils
import desktop.mall.presentation.viewmodel.BasketViewModel

@Composable
fun BasketScreen(viewModel: BasketViewModel = hiltViewModel()) {
    val basketProducts by viewModel.basketProducts.collectAsState(initial = listOf())

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
        //contentPadding = PaddingValues(10.dp)
    ) {
        items(basketProducts.size) { index ->
            BasketProductCard(basketProduct = basketProducts[index]) {
                viewModel.removeBasketProduct(it)
            }
        }

        item {
            Divider(color = GrayLine, thickness = 8.dp)
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "총 ${basketProducts.size} 개",
                    fontSize = 16.sp,
                    color = basketPrice
                )
                Text(
                    text = "₩ ${getTotalPrice(basketProducts)}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = basketPrice
                )
            }
        }

        item {
            Divider(color = GrayLine, thickness = 8.dp, modifier = Modifier.padding(vertical = 30.dp))
        }

        item {
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = basketPrice,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "구매하기",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        
        item {
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
fun BasketProductCard(basketProduct: BasketProduct, removeProduct: (Product) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp)
    ) {
        IconButton(
            onClick = { removeProduct(basketProduct.product) },
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "description",
                tint = GrayIcon
            )
        }
        
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.product_image), 
                contentDescription = "description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(120.dp)
                    .aspectRatio(1f)
            )

            Spacer(modifier = Modifier.width(20.dp))

            Column(
                modifier = Modifier.height(120.dp)
            ) {
                Text(
                    text = basketProduct.product.productName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Text(
                    text = basketProduct.product.category.categoryName,
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Text(
                        text = "총 ${basketProduct.count} 개",
                        color = GrayText,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(end = 10.dp, bottom = 20.dp)
                    )
                }
                Divider(color = GrayLine2, thickness = 1.dp)
            }
        }

        Text(
            text = "₩${NumberUtils.numberFormatPrice(basketProduct.product.price.finalPrice)}",
            fontSize = 18.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )
        
        //Price(product = basketProduct.product)
    }

    Divider(color = GrayLine2, thickness = 1.dp, modifier = Modifier.padding(top = 30.dp))
}

private fun getTotalPrice(list: List<BasketProduct>): String {
    val totalPrice = list.sumOf { it.product.price.finalPrice * it.count }
    return NumberUtils.numberFormatPrice(totalPrice)
}