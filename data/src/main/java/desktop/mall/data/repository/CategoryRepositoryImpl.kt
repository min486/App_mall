package desktop.mall.data.repository

import desktop.mall.data.datasource.ProductDataSource
import desktop.mall.data.db.dao.HeartDao
import desktop.mall.data.db.entity.toHeartProductEntity
import desktop.mall.domain.model.Category
import desktop.mall.domain.model.Product
import desktop.mall.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val dataSource: ProductDataSource,
    private val heartDao: HeartDao
) : CategoryRepository {
    override fun getCategories(): Flow<List<Category>> = flow {
        emit(
            listOf(
                Category.Outerwear, Category.Top, Category.Pants,
                Category.Suit, Category.Shirt, Category.Shoes,
                Category.Bag, Category.FashionAccessories
            )
        )
    }

    override fun getProductsByCategory(category: Category): Flow<List<Product>> {
        return dataSource.getHomeComponents().map { list ->  // 아래 만들어진 리스트로 map을 통해 flow로 반환
            list.filterIsInstance<Product>()
                .filter { product ->
                    product.category.categoryId == category.categoryId  // Product만 가져와서 카테고리 같은거만 필터 걸기
                }
        }.combine(heartDao.getAll()) { products, likeList ->
            products.map { product -> updateLikeStatus(product, likeList.map { it.productId }) }
        }
    }

    override suspend fun likeProduct(product: Product) {
        if (product.isLike) {
            heartDao.delete(product.productId)
        } else {
            heartDao.insert(product.toHeartProductEntity().copy(isLike = true))
        }
    }

    private fun updateLikeStatus(product: Product, likeProductIds: List<String>): Product {
        return product.copy(isLike = likeProductIds.contains(product.productId))
    }
}