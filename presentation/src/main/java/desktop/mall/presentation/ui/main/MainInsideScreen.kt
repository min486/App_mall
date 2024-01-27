package desktop.mall.presentation.ui.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import desktop.mall.presentation.ui.common.ProductCard
import desktop.mall.presentation.viewmodel.MainViewModel

@Composable
fun MainInsideScreen(viewModel: MainViewModel) {
    val productList by viewModel.productList.collectAsState(initial = listOf())

    LazyColumn {
        items(productList.size) {
            ProductCard(product = productList[it]) {

            }
        }
    }
}