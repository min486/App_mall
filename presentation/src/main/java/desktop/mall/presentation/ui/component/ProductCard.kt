package desktop.mall.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import desktop.mall.domain.model.Category
import desktop.mall.domain.model.Product
import desktop.mall.domain.model.Price
import desktop.mall.domain.model.SalesStatus
import desktop.mall.domain.model.Shop
import desktop.mall.presentation.R
import desktop.mall.presentation.delegate.ProductDelegate
import desktop.mall.presentation.model.ProductVM
import desktop.mall.presentation.ui.theme.Purple40

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductCard(navHostController: NavHostController, presentationVM: ProductVM) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Max)
            .padding(start = 6.dp, end = 6.dp, bottom = 30.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(0.dp),
        onClick = { presentationVM.openProduct(navHostController, presentationVM.model) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
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
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    fontSize = 14.sp,
                    text = presentationVM.model.productName
                )
                IconButton(onClick = { presentationVM.likeProduct(presentationVM.model) }) {
                    Icon(
                        if(presentationVM.model.isLike) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        "description"
                    )
                }
            }

            Price(presentationVM.model)
        }
    }
}

@Composable
fun Price(product: Product) {
    when (product.price.salesStatus) {
        SalesStatus.ON_SALE -> {
            Text(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                text = "${product.price.originPrice}원"
            )
        }

        SalesStatus.ON_DISCOUNT -> {
            Text(
                fontSize = 14.sp,
                text = "${product.price.originPrice}원",
                style = TextStyle(textDecoration = TextDecoration.LineThrough)
            )
            Text(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Purple40,
                text = "${product.price.finalPrice}원"
            )
        }

        SalesStatus.SOLD_OUT -> {
            Text(
                fontSize = 18.sp,
                color = Color(0xFF666666),
                text = "판매종료"
            )
        }
    }
}

@Preview
@Composable
private fun PreviewProductCard() {
    ProductCard(
        rememberNavController(),
        ProductVM(
            model = Product(
                productId = "1",
                productName = "상품 이름",
                imageUrl = "",
                price = Price(
                    30000,
                    30000,
                    SalesStatus.ON_SALE
                ),
                category = Category.Top,
                shop = Shop(
                    "1",
                    "샵 이름",
                    "",
                ),
                isNew = false,
                isFreeShipping = false,
                isLike = false
            ),
            object : ProductDelegate {
                override fun openProduct(navHostController: NavHostController, product: Product) {
                }

                override fun likeProduct(product: Product) {
                }
            }
        )
    )
}