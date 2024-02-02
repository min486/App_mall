package desktop.mall.presentation.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import desktop.mall.presentation.ui.iconpack.Event
import desktop.mall.presentation.ui.theme.GrayIcon
import desktop.mall.presentation.ui.theme.GrayLine
import desktop.mall.presentation.ui.theme.GrayLine2
import desktop.mall.presentation.viewmodel.MainViewModel
import desktop.mall.presentation.ui.IconPack
import desktop.mall.presentation.ui.iconpack.Chat
import desktop.mall.presentation.ui.iconpack.Document
import desktop.mall.presentation.ui.iconpack.Smile2

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainCategoryScreen(viewModel: MainViewModel, navController: NavHostController) {
    val categories by viewModel.categories.collectAsState(initial = listOf())

    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(20.dp)
        ) {
            items(categories.size, span = { GridItemSpan(1) }) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    elevation = 0.dp,
                    onClick = { viewModel.openCategory(navController, categories[it]) }
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = categories[it].categoryImage),
                            contentDescription = "description",
                            modifier = Modifier
                                //.fillMaxWidth()
                                .width(50.dp)
                                .aspectRatio(1f)
                        )

                        Text(
                            text = categories[it].categoryName,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp
                        )
                    }

                }
            }
        }

        Divider(color = GrayLine, thickness = 8.dp)

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier.padding(horizontal = 40.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = IconPack.Event,
                        contentDescription = null,
                        modifier = Modifier
                            .width(36.dp)
                            .padding(start = 4.dp, end = 10.dp)
                    )

                    Text(
                        text = "이벤트",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.KeyboardArrowDown, "description",
                        tint = GrayIcon
                    )
                }
            }

            Divider(
                color = GrayLine2,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = IconPack.Document,
                        contentDescription = null,
                        modifier = Modifier
                            .width(36.dp)
                            .padding(start = 4.dp, end = 10.dp)
                    )

                    Text(
                        text = "미누샵 소개",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.KeyboardArrowDown, "description",
                        tint = GrayIcon
                    )
                }
            }

            Divider(
                color = GrayLine2,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = IconPack.Chat,
                        contentDescription = null,
                        modifier = Modifier
                            .width(36.dp)
                            .padding(start = 4.dp, end = 10.dp)
                    )

                    Text(
                        text = "커뮤니티",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.KeyboardArrowDown, "description",
                        tint = GrayIcon
                    )
                }
            }

            Divider(
                color = GrayLine2,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = IconPack.Smile2,
                    contentDescription = null,
                    modifier = Modifier
                        .width(36.dp)
                        .padding(start = 4.dp, end = 10.dp)
                )

                Text(
                    text = "로그인",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}