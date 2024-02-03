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
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import desktop.mall.domain.model.Product
import desktop.mall.presentation.model.RankingVM
import desktop.mall.presentation.ui.IconPack
import desktop.mall.presentation.ui.iconpack.Heart
import desktop.mall.presentation.ui.iconpack.HeartFilled
import desktop.mall.presentation.ui.theme.GrayButton2
import desktop.mall.presentation.ui.theme.heart
import desktop.mall.presentation.utils.NumberUtils

@Composable
fun RankingCard(navHostController: NavHostController, presentationVM: RankingVM) {
    val scrollState = rememberLazyListState()
    val columnCount = presentationVM.model.productList.size / 2

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
            items(columnCount) {
                Column(
                    modifier = Modifier.padding(horizontal = 4.dp)
                ) {
                    RankingProductCard(presentationVM.model.productList[it * 2], presentationVM) { product ->
                        presentationVM.openRankingProduct(navHostController, product)
                    }
                    RankingProductCard(presentationVM.model.productList[it * 2 + 1], presentationVM) { product ->
                        presentationVM.openRankingProduct(navHostController, product)
                    }
                }
            }
        }

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
                text = "전체보기",
                fontSize = 14.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(100.dp))
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RankingProductCard(product: Product, presentationVM: RankingVM, onClick: (Product) -> Unit) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .padding(bottom = 20.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(0.dp),
        onClick = { onClick(product) }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(product.imageUrl)
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