package desktop.mall.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import desktop.mall.presentation.R
import desktop.mall.presentation.model.BannerVM

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BannerCard(presentationVM: BannerVM) {
    Card(
        onClick = { presentationVM.openBanner(presentationVM.model.bannerId) },  // 제네릭을 통해서 bannerId 쓸 수 있게함
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.banner_brown),
            contentDescription = "description",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2.5f)
        )
    }
}