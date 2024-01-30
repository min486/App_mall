package desktop.mall.domain.repository

import desktop.mall.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface LikeRepository {
    fun getLikeProducts(): Flow<List<Product>>
}