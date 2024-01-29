package desktop.mall.data.repository

import desktop.mall.data.datasource.ProductDataSource
import desktop.mall.domain.model.Category
import desktop.mall.domain.model.Product
import desktop.mall.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(private val dataSource: ProductDataSource) : CategoryRepository {
    override fun getCategories(): Flow<List<Category>> = flow {
        emit(
            listOf(
                Category.Top, Category.Bag, Category.Dress,
                Category.Outerwear, Category.Pants, Category.FashionAccessories,
                Category.Shoes, Category.Skirt
            )
        )
    }

    override fun getProductsByCategory(category: Category): Flow<List<Product>> {
        return dataSource.getProducts().map { list ->  // 아래 만들어진 리스트로 map을 통해 flow로 반환
            list.filterIsInstance<Product>()
                .filter { product ->
                    product.category.categoryId == category.categoryId  // Product만 가져와서 카테고리 같은거만 필터 걸기
                }
        }
    }
}