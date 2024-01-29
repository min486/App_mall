package desktop.mall.domain.repository

import desktop.mall.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductDetailRepository {
    fun getProductDetail(productId: String): Flow<Product>
}