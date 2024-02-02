package desktop.mall.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import desktop.mall.domain.model.Category
import desktop.mall.domain.model.Product
import desktop.mall.domain.model.Price
import desktop.mall.domain.model.SalesStatus
import desktop.mall.domain.model.Shop
import desktop.mall.presentation.delegate.ProductDelegate
import desktop.mall.presentation.model.ProductVM
import desktop.mall.presentation.ui.IconPack
import desktop.mall.presentation.ui.iconpack.Heart
import desktop.mall.presentation.ui.iconpack.HeartFilled
import desktop.mall.presentation.ui.theme.Purple40
import desktop.mall.presentation.ui.theme.heart
import desktop.mall.presentation.utils.NumberUtils

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductCard(navHostController: NavHostController, presentationVM: ProductVM) {
    Card(
        onClick = { presentationVM.openProduct(navHostController, presentationVM.model) },
        modifier = Modifier
            .fillMaxWidth()
            //.height(intrinsicSize = IntrinsicSize.Max)
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
        shape = RoundedCornerShape(0.dp),
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(presentationVM.model.imageUrl)
                        .apply(block = fun ImageRequest.Builder.(){
                            crossfade(true)
                        }).build()
                ),
                contentDescription = "description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.8f)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = presentationVM.model.productName,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                IconButton(
                    onClick = { presentationVM.likeProduct(presentationVM.model) },
                    // IconButton의 위아래로 padding이 들어가서 제거하기 위해 .then() 사용
                    modifier = Modifier.then(Modifier.size(24.dp))
                ) {
                    if(presentationVM.model.isLike) {
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
                text = "${NumberUtils.numberFormatPrice(presentationVM.model.price.finalPrice)}",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }
    }
}

// 상품가격 분기 처리 (사용 x)
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