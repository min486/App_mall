package desktop.mall.domain.usecase

import desktop.mall.domain.model.Category
import desktop.mall.domain.model.Product
import desktop.mall.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryUseCase @Inject constructor(private val categoryRepository: CategoryRepository) {

    fun getCategories(): Flow<List<Category>> {
        return categoryRepository.getCategories()
    }
    fun getProductsByCategory(category: Category): Flow<List<Product>> {
        return categoryRepository.getProductsByCategory(category)
    }

    suspend fun likeProduct(product: Product) {
        categoryRepository.likeProduct(product)
    }
}