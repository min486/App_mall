package desktop.mall.domain.usecase

import desktop.mall.domain.model.Category
import desktop.mall.domain.model.Product
import desktop.mall.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryUseCase @Inject constructor(private val repository: CategoryRepository) {

    fun getCategories(): Flow<List<Category>> {
        return repository.getCategories()
    }
    fun getProductsByCategory(category: Category): Flow<List<Product>> {
        return repository.getProductsByCategory(category)
    }
}