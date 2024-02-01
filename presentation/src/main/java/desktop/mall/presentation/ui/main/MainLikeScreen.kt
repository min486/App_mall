package desktop.mall.presentation.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import desktop.mall.presentation.model.ProductVM
import desktop.mall.presentation.ui.component.ProductCard
import desktop.mall.presentation.ui.theme.GrayLine2
import desktop.mall.presentation.ui.theme.GrayText2
import desktop.mall.presentation.ui.theme.heart
import desktop.mall.presentation.viewmodel.MainViewModel

@Composable
fun MainLikeScreen(
    navHostController: NavHostController,
    viewModel: MainViewModel
) {
    val likeProducts by viewModel.likeProducts.collectAsState(initial = listOf())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null,
                tint = heart,
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 16.dp),
            )

            Text(
                text = "LIKE",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp, end = 12.dp),
            )

            Text(
                text = "${likeProducts.size}",
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
                color = GrayText2
            )
        }

        Divider(color = GrayLine2, thickness = 1.dp, modifier = Modifier.padding(top = 20.dp, bottom = 40.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            //modifier = Modifier.padding(20.dp)
        ) {
            items(likeProducts.size, span = { GridItemSpan(1) }) { index ->
                ProductCard(navHostController = navHostController, presentationVM = likeProducts[index] as ProductVM)
            }
        }
    }
}