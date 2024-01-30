package desktop.mall.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import desktop.mall.domain.model.Category
import desktop.mall.domain.model.Product
import desktop.mall.domain.usecase.CategoryUseCase
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
class CategoryViewModel @Inject constructor(private val useCase: CategoryUseCase)
    : ViewModel(), ProductDelegate {
    private val _products = MutableStateFlow<List<ProductVM>>(listOf())  // 초기값은 빈 리스트로
    val products: StateFlow<List<ProductVM>> = _products

    suspend fun updateCategory(category: Category) {
        useCase.getProductsByCategory(category).collectLatest {
            _products.emit(convertToPresentationVM(it))  // List<Product> -> List<ProductVM>
        }
    }

    override fun openProduct(navHostController: NavHostController, product: Product) {
        NavigationUtils.navigate(navHostController, NavigationRouteName.PRODUCT_DETAIL, product)
    }

    override fun likeProduct(product: Product) {
        viewModelScope.launch {
            useCase.likeProduct(product)
        }
    }

    private fun convertToPresentationVM(list: List<Product>): List<ProductVM> {
        return list.map {
            ProductVM(it, this)
        }
    }
}