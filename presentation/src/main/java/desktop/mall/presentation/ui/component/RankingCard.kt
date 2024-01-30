package desktop.mall.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
                    RankingProductCard(presentationVM.model.productList[it * 2], presentationVM) { product ->
                        presentationVM.openRankingProduct(navHostController, product)
                    }
                    RankingProductCard(presentationVM.model.productList[it * 2 + 1], presentationVM) { product ->
                        presentationVM.openRankingProduct(navHostController, product)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RankingProductCard(product: Product, presentationVM: RankingVM, onClick: (Product) -> Unit) {
    Card(
        //modifier = Modifier.fillMaxWidth(),
        modifier = Modifier
            .width(200.dp)
            .padding(bottom = 20.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(0.dp),
        onClick = { onClick(product) }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.product_image),
                contentDescription = "description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    //.width(172.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    //.padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    fontSize = 14.sp,
                    text = product.productName
                )
                IconButton(onClick = { presentationVM.likeProduct(product) }) {
                    Icon(
                        if(product.isLike) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        "description"
                    )
                }
            }

            Price(product = product)
        }
    }
}