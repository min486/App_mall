package desktop.mall.presentation.ui.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import desktop.mall.presentation.model.ProductVM
import desktop.mall.presentation.ui.component.ProductCard
import desktop.mall.presentation.viewmodel.MainViewModel

@Composable
fun MainLikeScreen(
    navHostController: NavHostController,
    viewModel: MainViewModel
) {
    val likeProducts by viewModel.likeProducts.collectAsState(initial = listOf())

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(likeProducts.size) { index ->
            ProductCard(navHostController = navHostController, presentationVM = likeProducts[index] as ProductVM)
        }
    }
}