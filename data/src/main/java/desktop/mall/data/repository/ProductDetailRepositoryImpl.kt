package desktop.mall.data.repository

import desktop.mall.data.datasource.ProductDataSource
import desktop.mall.data.db.dao.BasketDao
import desktop.mall.data.db.entity.toBasketProductEntity
import desktop.mall.domain.model.Product
import desktop.mall.domain.repository.ProductDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductDetailRepositoryImpl @Inject constructor(
    private val dataSource: ProductDataSource,
    private val basketDao: BasketDao
) : ProductDetailRepository {

    override fun getProductDetail(productId: String): Flow<Product> {
        return dataSource.getHomeComponents().map { products ->
            products.filterIsInstance<Product>().first { it.productId == productId }
        }
    }

    override suspend fun addBasket(product: Product) {
        // 기존에 데이터가 있는지 확인
        val alreadyExistProduct = basketDao.get(product.productId)

        if (alreadyExistProduct == null) {
            basketDao.insert(product.toBasketProductEntity())
        } else {
            basketDao.insert(alreadyExistProduct.copy(count = alreadyExistProduct.count + 1))
        }
    }
}