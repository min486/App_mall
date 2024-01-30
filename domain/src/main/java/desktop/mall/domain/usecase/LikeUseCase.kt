package desktop.mall.domain.usecase

import desktop.mall.domain.model.Product
import desktop.mall.domain.repository.LikeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LikeUseCase @Inject constructor(
    private val repository: LikeRepository
) {

    fun getLikeProducts(): Flow<List<Product>> {
        return repository.getLikeProducts()
    }
}