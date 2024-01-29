package desktop.mall.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import desktop.mall.domain.model.Product
import desktop.mall.domain.usecase.ProductDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(private val useCase: ProductDetailUseCase) :
    ViewModel() {

    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product

    suspend fun updateProduct(productId: String) {
        useCase.getProductDetail(productId).collectLatest {
            _product.emit(it)
        }
    }

    // 장바구니 추가 기능
    fun addCart(productId: String) {

    }
}