package desktop.mall.domain.repository

import desktop.mall.domain.model.Category
import desktop.mall.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getCategories(): Flow<List<Category>>
    fun getProductsByCategory(category: Category): Flow<List<Product>>

    suspend fun likeProduct(product: Product)
}