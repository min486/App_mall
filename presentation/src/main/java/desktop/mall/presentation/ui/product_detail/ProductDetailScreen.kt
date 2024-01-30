package desktop.mall.presentation.ui.product_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import desktop.mall.presentation.R
import desktop.mall.presentation.ui.theme.Purple40
import desktop.mall.presentation.utils.NumberUtils
import desktop.mall.presentation.viewmodel.ProductDetailViewModel

@Composable
fun ProductDetailScreen(productId: String, viewModel: ProductDetailViewModel = hiltViewModel()) {
    val product by viewModel.product.collectAsState()

    // product 값 가져오기 위해 productId로 전달
    LaunchedEffect(key1 = productId) {
        viewModel.updateProduct(productId)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1.5f)) {
            Image(
                painter = painterResource(id = R.drawable.product_image),
                contentDescription = "description",
                modifier = Modifier
                    .fillMaxWidth(),
                //.height(500.dp),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 0.dp),
            elevation = 0.dp
        ) {
            Column {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = "${product?.productName}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    // 하트 추가
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    //text = "${product?.price?.finalPrice}",
                    text = "${NumberUtils.numberFormatPrice(product?.price?.finalPrice)}",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )

            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            // 하트 추가
            Text(
                text = "test",
            )

            Button(
                onClick = { viewModel.addBasket(product) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Purple40,
                    contentColor = Color.White
                )
            ) {
                Text(text = "장바구니")
            }
        }

    }
}