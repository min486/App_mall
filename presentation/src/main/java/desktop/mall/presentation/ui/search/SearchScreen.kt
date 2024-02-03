package desktop.mall.presentation.ui.search

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import desktop.mall.presentation.ui.component.ProductCard
import desktop.mall.presentation.ui.theme.GrayLine3
import desktop.mall.presentation.viewmodel.SearchViewModel

@Composable
fun SearchScreen(
    navHostController: NavHostController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val searchResult by viewModel.searchResult.collectAsState()
    val searchKeywords by viewModel.searchKeywords.collectAsState(listOf())
    var keyword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        SearchBox(
            keyword = keyword,
            onValueChange = { keyword = it },
            searchAction = {
                viewModel.search(keyword)
            }
        )

        if (searchResult.isEmpty()) {
            // 검색결과 없으면 (처음 화면)
            Spacer(modifier = Modifier.height(20.dp))
            
            Text(
                text = "최근 검색어",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            LazyRow(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(top = 10.dp)
            ) {
                items(searchKeywords.size) { index ->
                    // 최근 검색어가 위로올 수 있게 reversed()로 순서 뒤집기
                    val currentKeyword = searchKeywords.reversed()[index].keyword

                    Button(
                        onClick = {
                            keyword = currentKeyword
                            viewModel.search(keyword)
                        },
                        shape = RoundedCornerShape(20.dp),
                        border = BorderStroke(1.dp, GrayLine3),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                        modifier = Modifier.padding(end = 10.dp)
                    ) {
                        Text(
                            text = currentKeyword,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        } else {
            // 검색결과 있으면
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 20.dp)
            ) {
                items(searchResult.size) { index ->
                    ProductCard(navHostController = navHostController, presentationVM = searchResult[index])
                }
            }
        }
    }
}

@Composable
fun SearchBox(
    keyword: String,
    onValueChange: (String) -> Unit,  // 검색어 변경될때마다
    searchAction: () -> Unit,  // 키보드 확인 눌렀을때
) {
    Row(Modifier.fillMaxWidth()) {
        TextField(value = keyword,
            onValueChange = onValueChange,
            placeholder = { Text(text = "검색어를 입력해주세요") },
            shape = RoundedCornerShape(size = 8.dp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search,
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words,
                autoCorrect = true
            ),
            keyboardActions = KeyboardActions(
                onSearch = { searchAction() }  // () 빼먹음..
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            maxLines = 1,
            singleLine = true,
            leadingIcon = { Icon(Icons.Filled.Search, "description") }
        )
    }
}