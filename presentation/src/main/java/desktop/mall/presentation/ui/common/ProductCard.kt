package desktop.mall.presentation.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import desktop.mall.domain.model.Category
import desktop.mall.domain.model.Product
import desktop.mall.domain.model.Price
import desktop.mall.domain.model.SalesStatus
import desktop.mall.domain.model.Shop
import desktop.mall.presentation.R
import desktop.mall.presentation.ui.theme.Purple40

@Composable
fun ProductCard(product: Product, onClick: (Product) -> Unit?) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Max)
            .padding(10.dp)
            .shadow(elevation = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.product_image),
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
            )
            Text(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                 text = product.shop.shopName
                // text = product.productName
            )
            Text(
                fontSize = 14.sp,
                text = product.productName
            )
            Price(product)
        }
    }
}

@Composable
private fun Price(product: Product) {
    when(product.price.salesStatus) {
        SalesStatus.ON_SALE -> {
            Text(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                text = "${product.price.originPrice}"
            )
        }
        SalesStatus.ON_DISCOUNT -> {
            Text(
                fontSize = 14.sp,
                text = "${product.price.originPrice}",
                style = TextStyle(textDecoration = TextDecoration.LineThrough)
            )
            Row {
                Text(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    text = "할인가: "
                )
                Text(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Purple40,
                    text = "${product.price.finalPrice}"
                )
            }
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
        product = Product(
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
            isFreeShipping = false
        )
    ) {
    }
}

@Preview
@Composable
private fun PreviewProductCardDiscount() {
    ProductCard(
        product = Product(
            productId = "1",
            productName = "상품 이름",
            imageUrl = "",
            price = Price(
                30000,
                20000,
                SalesStatus.ON_DISCOUNT
            ),
            category = Category.Top,
            shop = Shop(
                "1",
                "샵 이름",
                "",
            ),
            isNew = false,
            isFreeShipping = false
        )
    ) {
    }
}

@Preview
@Composable
private fun PreviewProductCardSoldout() {
    ProductCard(
        product = Product(
            productId = "1",
            productName = "상품 이름",
            imageUrl = "",
            price = Price(
                30000,
                20000,
                SalesStatus.SOLD_OUT
            ),
            category = Category.Top,
            shop = Shop(
                "1",
                "샵 이름",
                "",
            ),
            isNew = false,
            isFreeShipping = false
        )
    ) {
    }
}