package desktop.mall.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import desktop.mall.domain.model.Product
import desktop.mall.domain.model.SearchKeyword
import desktop.mall.domain.usecase.SearchUseCase
import desktop.mall.presentation.delegate.ProductDelegate
import desktop.mall.presentation.model.ProductVM
import desktop.mall.presentation.ui.NavigationRouteName
import desktop.mall.presentation.utils.NavigationUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val useCase: SearchUseCase) :
    ViewModel(), ProductDelegate {

    // 바깥에서 데이터를 읽기만 할 수 있게 만듬
    private val _searchResult = MutableStateFlow<List<ProductVM>>(listOf())
    val searchResult: StateFlow<List<ProductVM>> = _searchResult

    val searchKeywords = useCase.getSearchKeywords()

    fun search(keyword: String) {
        viewModelScope.launch {
            useCase.search(SearchKeyword(keyword = keyword)).collectLatest {
                _searchResult.emit(it.map(::convertToProductVM))
            }
        }
    }

    private fun convertToProductVM(product: Product): ProductVM {
        return ProductVM(product, this)
    }

    override fun openProduct(navHostController: NavHostController, product: Product) {
        NavigationUtils.navigate(navHostController, NavigationRouteName.PRODUCT_DETAIL, product)
    }

    override fun likeProduct(product: Product) {
        viewModelScope.launch {
            useCase.likeProduct(product)
        }
    }
}