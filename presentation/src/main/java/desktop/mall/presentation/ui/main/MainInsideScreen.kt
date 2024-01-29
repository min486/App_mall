package desktop.mall.presentation.ui.main

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import desktop.mall.domain.model.Banner
import desktop.mall.domain.model.BannerList
import desktop.mall.domain.model.Carousel
import desktop.mall.domain.model.ModelType
import desktop.mall.domain.model.Product
import desktop.mall.domain.model.Ranking
import desktop.mall.presentation.ui.component.BannerCard
import desktop.mall.presentation.ui.component.BannerListCard
import desktop.mall.presentation.ui.component.CarouselCard
import desktop.mall.presentation.ui.component.ProductCard
import desktop.mall.presentation.ui.component.RankingCard
import desktop.mall.presentation.viewmodel.MainViewModel

@Composable
fun MainInsideScreen(viewModel: MainViewModel) {
    val modelList by viewModel.modelList.collectAsState(initial = listOf())
    val columnCount by viewModel.columnCount.collectAsState()

    LazyVerticalGrid(columns = GridCells.Fixed(columnCount)) {
        items(modelList.size, span = { index ->
            val item = modelList[index]
            val spanCount = getSpanCountByType(item.type, columnCount)

            GridItemSpan(spanCount)
        }) {
            when(val item = modelList[it]) {
                is BannerList -> BannerListCard(model = item) { model ->
                    viewModel.openBannerList(model)
                }
                is Banner -> BannerCard(model = item) { model ->  // item as Banner로 스마트 캐스팅됨
                    viewModel.openBanner(model)
                }
                is Product -> ProductCard(product = item) { model ->
                    viewModel.openProduct(model)
                }
                is Carousel -> CarouselCard(model = item) { model ->
                    viewModel.openCarouselProduct(model)
                }
                is Ranking -> RankingCard(model = item) { model ->
                    viewModel.openRankingProduct(model)
                }
            }
        }
    }
}

private fun getSpanCountByType(type: ModelType, defaultColumnCount: Int): Int {
    return when(type) {
        ModelType.PRODUCT -> 1
        ModelType.BANNER, ModelType.BANNER_LIST,
        ModelType.CAROUSEL, ModelType.RANKING -> defaultColumnCount  // 가로 가득차게
    }
}