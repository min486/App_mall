package desktop.mall.domain.repository

import desktop.mall.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductDetailRepository {
    fun getProductDetail(productId: String): Flow<Product>

    // 상품상세 페이지에서만 장바구니 기능 들어감
    suspend fun addBasket(product: Product)
}