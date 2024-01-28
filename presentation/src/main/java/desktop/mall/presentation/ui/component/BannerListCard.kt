package desktop.mall.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import desktop.mall.domain.model.BannerList
import desktop.mall.presentation.R
import kotlinx.coroutines.delay
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.pager.HorizontalPager
import desktop.mall.presentation.ui.theme.LightBlack

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannerListCard(model: BannerList) {
    val pagerState = rememberPagerState()

    // 배너카드가 보일때, 카드의 view와 lifecycle을 동일하게 가져가는 scope
    // 배너화면을 벗어나면(다른 곳을 보면) scope가 정지됨
    LaunchedEffect(key1 = pagerState) {
        autoScrollInfinity(pagerState)
    }

    HorizontalPager(count = model.imageList.size, state = pagerState) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = "description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.8f)
            )
            Box(
                contentAlignment = Alignment.TopEnd,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp, top = 16.dp, end = 16.dp, bottom = 0.dp)
            ) {
                Text(
                    text = "${it + 1} / ${model.imageList.size}",
                    color = Color.White,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(LightBlack)
                        .padding(start = 10.dp, top = 2.dp, end = 10.dp, bottom = 2.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
private suspend fun autoScrollInfinity(pagerState: PagerState) {
    while (true) {
        delay(1000)
        val currentPage = pagerState.currentPage
        var nextPage = currentPage + 1
        if (nextPage >= pagerState.pageCount) {
            nextPage = 0
        }
        pagerState.animateScrollToPage(nextPage)
    }
}