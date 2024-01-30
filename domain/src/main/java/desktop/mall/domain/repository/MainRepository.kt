package desktop.mall.domain.repository

import desktop.mall.domain.model.BaseModel
import desktop.mall.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getModelList(): Flow<List<BaseModel>>

    suspend fun likeProduct(product: Product)
}