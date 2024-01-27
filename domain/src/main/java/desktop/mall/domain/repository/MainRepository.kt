package desktop.mall.domain.repository

import desktop.mall.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getProductList(): Flow<List<Product>>
}