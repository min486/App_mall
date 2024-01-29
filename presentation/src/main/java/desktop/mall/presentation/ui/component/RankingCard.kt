package desktop.mall.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import desktop.mall.domain.model.Product
import desktop.mall.presentation.R
import desktop.mall.presentation.model.RankingVM

@Composable
fun RankingCard(navHostController: NavHostController, presentationVM: RankingVM) {
    val scrollState = rememberLazyListState()
    val columnCount = presentationVM.model.productList.size / 2

    Column {
        Text(
            text = presentationVM.model.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 12.dp)
        )

        LazyRow(
            state = scrollState,
            modifier = Modifier.padding(start = 16.dp)
        ) {
            items(columnCount) {
                Column(
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    RankingProductCard(presentationVM.model.productList[it * 2]) { product ->
                        presentationVM.openRankingProduct(navHostController, product)
                    }
                    RankingProductCard(presentationVM.model.productList[it * 2 + 1]) { product ->
                        presentationVM.openRankingProduct(navHostController, product)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RankingProductCard(product: Product, onClick: (Product) -> Unit) {
    Card(
        modifier = Modifier.padding(bottom = 20.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(0.dp),
        onClick = { onClick(product) }
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                //.padding(bottom = 20.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.product_image),
                contentDescription = "description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(172.dp)
                    .aspectRatio(1f)
                    .padding(bottom = 8.dp)
            )
            Text(text = product.productName)
            Price(product = product)
        }
    }
}