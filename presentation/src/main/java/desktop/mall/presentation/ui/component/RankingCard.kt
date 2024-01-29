package desktop.mall.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import desktop.mall.domain.model.Product
import desktop.mall.domain.model.Ranking
import desktop.mall.presentation.R

@Composable
fun RankingCard(model: Ranking, onClick: (Product) -> Unit) {
    val scrollState = rememberLazyListState()
    val columnCount = model.productList.size / 2

    Column {
        Text(
            text = model.title,
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
                    RankingProductCard(model.productList[it * 2], onClick)
                    RankingProductCard(model.productList[it * 2 + 1], onClick)
                }
            }
        }
    }
}

@Composable
fun RankingProductCard(product: Product, onClick: (Product) -> Unit) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(bottom = 20.dp)
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.product_image
            ),
            contentDescription = "description",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(172.dp)
                .aspectRatio(1f)
        )
        Text(text = product.productName)
        Price(product = product)
    }
}