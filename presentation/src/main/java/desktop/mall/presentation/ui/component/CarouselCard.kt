package desktop.mall.presentation.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import desktop.mall.domain.model.Product
import desktop.mall.presentation.R
import desktop.mall.presentation.model.CarouselVM
import desktop.mall.presentation.ui.IconPack
import desktop.mall.presentation.ui.iconpack.Heart
import desktop.mall.presentation.ui.iconpack.HeartFilled
import desktop.mall.presentation.ui.theme.GrayButton2
import desktop.mall.presentation.ui.theme.heart
import desktop.mall.presentation.utils.NumberUtils

@Composable
fun CarouselCard(navHostController: NavHostController, presentationVM: CarouselVM) {
    val scrollState = rememberLazyListState()

    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Text(
            text = presentationVM.model.title,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.padding(top = 30.dp, bottom = 10.dp)
        )

        LazyRow(
            state = scrollState,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            items(presentationVM.model.productList.size) {
                CarouselProductCard(product = presentationVM.model.productList[it], presentationVM) { product ->
                    presentationVM.openCarouselProduct(navHostController, product)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp),
            colors = ButtonDefaults.buttonColors(Color.White),
            border = BorderStroke(1.dp, GrayButton2),
            shape = RoundedCornerShape(0.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp
            )
        ) {
            Text(
                text = "추천상품 전체보기",
                fontSize = 14.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(50.dp))
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun CarouselProductCard(product: Product, presentationVM: CarouselVM, onClick: (Product) -> Unit) {
    Card(
        onClick = { onClick(product) },
        elevation = 0.dp,
        modifier = Modifier
            .width(164.dp)
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.product_image),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = product.productName,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                IconButton(
                    onClick = { presentationVM.likeProduct(product) },
                    // IconButton의 위아래로 padding이 들어감. 이를 제거하기 위해 .then() 사용
                    modifier = Modifier.then(Modifier.size(24.dp))
                ) {
                    if(product.isLike) {
                        Icon(
                            imageVector = IconPack.HeartFilled,
                            contentDescription = "description",
                            tint = heart
                        )
                    } else {
                        Icon(
                            imageVector = IconPack.Heart,
                            contentDescription = "description",
                            tint = Color.Black
                        )
                    }
                }
            }

            Text(
                text = "${NumberUtils.numberFormatPrice(product.price.finalPrice)}",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }
    }
}