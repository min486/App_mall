package desktop.mall.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import desktop.mall.domain.model.Category
import desktop.mall.domain.model.Product
import desktop.mall.domain.usecase.CategoryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val useCase: CategoryUseCase) : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(listOf())  // 초기값은 빈 리스트로
    val products: StateFlow<List<Product>> = _products

    suspend fun updateCategory(category: Category) {
        useCase.getProductsByCategory(category).collectLatest {
            _products.emit(it)
        }
    }

    fun openProduct(product: Product) {

    }
}