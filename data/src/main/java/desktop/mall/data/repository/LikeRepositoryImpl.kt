package desktop.mall.data.repository

import desktop.mall.data.db.dao.HeartDao
import desktop.mall.data.db.entity.toDomainModel
import desktop.mall.domain.model.Product
import desktop.mall.domain.repository.LikeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LikeRepositoryImpl @Inject constructor(
    private val heartDao: HeartDao
) : LikeRepository {

    override fun getLikeProducts(): Flow<List<Product>> {
        return heartDao.getAll().map { entities ->
            entities.map { it.toDomainModel() }
        }
    }
}