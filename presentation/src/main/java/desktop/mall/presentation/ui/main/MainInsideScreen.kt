package desktop.mall.presentation.ui.main

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import desktop.mall.domain.model.Banner
import desktop.mall.domain.model.BannerList
import desktop.mall.domain.model.ModelType
import desktop.mall.domain.model.Product
import desktop.mall.presentation.ui.component.BannerCard
import desktop.mall.presentation.ui.component.BannerListCard
import desktop.mall.presentation.ui.component.ProductCard
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
                is BannerList -> BannerListCard(model = item)
                is Banner -> BannerCard(model = item)  // item as Banner로 스마트 캐스팅됨
                is Product -> ProductCard(product = item) {

                }
            }
        }
    }
}

private fun getSpanCountByType(type: ModelType, defaultColumnCount: Int): Int {
    return when(type) {
        ModelType.PRODUCT -> 1
        ModelType.BANNER, ModelType.BANNER_LIST -> defaultColumnCount  // 가로 가득차게
    }
}

