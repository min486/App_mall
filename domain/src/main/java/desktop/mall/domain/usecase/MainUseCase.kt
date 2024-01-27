package desktop.mall.domain.usecase

import desktop.mall.domain.model.Product
import desktop.mall.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainUseCase @Inject constructor(private val mainRepository: MainRepository) {

    fun getProductList() : Flow<List<Product>> {
        return mainRepository.getProductList()
    }
}