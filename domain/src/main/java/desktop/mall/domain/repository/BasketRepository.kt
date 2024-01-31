package desktop.mall.domain.repository

import desktop.mall.domain.model.BasketProduct
import desktop.mall.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface BasketRepository {
    // 장바구니 화면에 보여줄 상품들
    fun getBasketProducts(): Flow<List<BasketProduct>>

    // 장바구니에서 상품 삭제할때
    suspend fun removeBasketProduct(product: Product)
}