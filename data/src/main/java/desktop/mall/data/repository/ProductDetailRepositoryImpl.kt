package desktop.mall.data.repository

import desktop.mall.data.datasource.ProductDataSource
import desktop.mall.domain.model.Product
import desktop.mall.domain.repository.ProductDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductDetailRepositoryImpl @Inject constructor(private val dataSource: ProductDataSource) :
    ProductDetailRepository {

    override fun getProductDetail(productId: String): Flow<Product> {
        return dataSource.getHomeComponents().map { products ->
            products.filterIsInstance<Product>().first { it.productId == productId }
        }
    }
}