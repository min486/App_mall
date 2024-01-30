package desktop.mall.data.repository

import desktop.mall.data.datasource.ProductDataSource
import desktop.mall.data.db.dao.HeartDao
import desktop.mall.data.db.entity.toHeartProductEntity
import desktop.mall.domain.model.BaseModel
import desktop.mall.domain.model.Carousel
import desktop.mall.domain.model.Product
import desktop.mall.domain.model.Ranking
import desktop.mall.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val dataSource: ProductDataSource,
    private val heartDao: HeartDao
) : MainRepository {
    override fun getModelList(): Flow<List<BaseModel>> {
        // combine()을 통해 가져오게 되면 하나만 변경되어도 업데이트 된다
        // like가 중간중간 업데이트 되더라도 flow에 데이터가 계속 흐른다
        return dataSource.getHomeComponents().combine(heartDao.getAll()) { homeComponents, likeList ->
            homeComponents.map { model -> mappingLike(model, likeList.map { it.productId }) }
        }
    }

    override suspend fun likeProduct(product: Product) {
        if (product.isLike) {
            heartDao.delete(product.productId)
        } else {
            heartDao.insert(product.toHeartProductEntity())
        }
    }

    private fun mappingLike(baseModel: BaseModel, likeProductIds: List<String>): BaseModel {
        return when (baseModel) {
            is Carousel -> { baseModel.copy(productList = baseModel.productList.map { updateLikeStatus(it, likeProductIds) })}
            is Ranking -> { baseModel.copy(productList = baseModel.productList.map { updateLikeStatus(it, likeProductIds) })}
            is Product -> { updateLikeStatus(baseModel, likeProductIds )}
            else -> baseModel
        }
    }

    private fun updateLikeStatus(product: Product, likeProductIds: List<String>): Product {
        return product.copy(isLike = likeProductIds.contains(product.productId))
    }
}