package desktop.mall.domain.usecase

import desktop.mall.domain.model.Product
import desktop.mall.domain.repository.ProductDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductDetailUseCase @Inject constructor(private val repository: ProductDetailRepository) {

    fun getProductDetail(productId: String): Flow<Product> {
        return repository.getProductDetail(productId)
    }

    suspend fun addBasket(product: Product) {
        repository.addBasket(product)
    }
}