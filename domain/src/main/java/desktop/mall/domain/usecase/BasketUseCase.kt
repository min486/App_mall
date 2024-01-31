package desktop.mall.domain.usecase

import desktop.mall.domain.model.BasketProduct
import desktop.mall.domain.model.Product
import desktop.mall.domain.repository.BasketRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BasketUseCase @Inject constructor(
    private val basketRepository: BasketRepository
) {

    fun getBasketProducts(): Flow<List<BasketProduct>> {
        return basketRepository.getBasketProducts()
    }

    suspend fun removeBasketProducts(product: Product) {
        basketRepository.removeBasketProduct(product = product)
    }
}