package desktop.mall.presentation.ui.main

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import desktop.mall.domain.model.ModelType
import desktop.mall.presentation.model.BannerListVM
import desktop.mall.presentation.model.BannerVM
import desktop.mall.presentation.model.CarouselVM
import desktop.mall.presentation.model.ProductVM
import desktop.mall.presentation.model.RankingVM
import desktop.mall.presentation.ui.component.BannerCard
import desktop.mall.presentation.ui.component.BannerListCard
import desktop.mall.presentation.ui.component.CarouselCard
import desktop.mall.presentation.ui.component.ProductCard
import desktop.mall.presentation.ui.component.RankingCard
import desktop.mall.presentation.viewmodel.MainViewModel

@Composable
fun MainHomeScreen(navController: NavHostController, viewModel: MainViewModel) {
    val modelList by viewModel.modelList.collectAsState(initial = listOf())
    val columnCount by viewModel.columnCount.collectAsState()

    LazyVerticalGrid(columns = GridCells.Fixed(columnCount)) {
        items(modelList.size, span = { index ->
            val item = modelList[index]
            val spanCount = getSpanCountByType(item.model.type, columnCount)

            GridItemSpan(spanCount)
        }) {
            when(val item = modelList[it]) {
                is BannerVM -> BannerCard(presentationVM = item)  // item as BannerVM으로 스마트 캐스팅됨
                is BannerListVM -> BannerListCard(presentationVM = item)
                is ProductVM -> ProductCard(navHostController = navController, presentationVM = item)
                is CarouselVM -> CarouselCard(navHostController = navController, presentationVM = item)
                is RankingVM -> RankingCard(navHostController = navController, presentationVM = item)
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