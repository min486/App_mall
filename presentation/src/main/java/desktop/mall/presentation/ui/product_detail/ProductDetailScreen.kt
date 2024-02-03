package desktop.mall.presentation.ui.product_detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import desktop.mall.presentation.ui.IconPack
import desktop.mall.presentation.ui.iconpack.HeartFilled
import desktop.mall.presentation.ui.theme.GrayButton
import desktop.mall.presentation.ui.theme.basketPrice
import desktop.mall.presentation.ui.theme.heart
import desktop.mall.presentation.utils.NumberUtils
import desktop.mall.presentation.viewmodel.ProductDetailViewModel

@Composable
fun ProductDetailScreen(productId: String, viewModel: ProductDetailViewModel = hiltViewModel()) {
    val product by viewModel.product.collectAsState()

    // product 값 가져오기 위해 productId로 전달
    LaunchedEffect(key1 = productId) {
        viewModel.updateProduct(productId)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(product?.imageUrl)
                    .apply(block = fun ImageRequest.Builder.(){
                        crossfade(true)
                    }).build()
            ),
            contentDescription = "description",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${product?.productName}",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Icon(
                    modifier = Modifier.then(Modifier.size(30.dp)),
                    imageVector = IconPack.HeartFilled,
                    contentDescription = "description",
                    tint = heart
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "₩ ${NumberUtils.numberFormatPrice(product?.price?.finalPrice)}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp),
        ) {
            Button(
                onClick = { viewModel.addBasket(product) },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(50.dp)
                    .padding(end = 4.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black
                ),
                border = BorderStroke(1.dp, GrayButton),
                shape = RoundedCornerShape(0.dp),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp
                )
            ) {
                Text(
                    text = "장바구니",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            }

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 4.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = basketPrice,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(0.dp),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp
                )
            ) {
                Text(
                    text = "구매하기",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
    }
}