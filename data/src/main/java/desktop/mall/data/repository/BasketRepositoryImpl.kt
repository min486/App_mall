package desktop.mall.data.repository

import desktop.mall.data.db.dao.BasketDao
import desktop.mall.data.db.entity.toDomainModel
import desktop.mall.domain.model.BasketProduct
import desktop.mall.domain.model.Product
import desktop.mall.domain.repository.BasketRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BasketRepositoryImpl @Inject constructor(
    private val basketDao: BasketDao
) : BasketRepository {
    override fun getBasketProducts(): Flow<List<BasketProduct>> {
        return basketDao.getAll().map { list ->
            list.map { BasketProduct(it.toDomainModel(), it.count) }
        }
    }

    override suspend fun removeBasketProduct(product: Product) {
        return basketDao.delete(product.productId)
    }
}