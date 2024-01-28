package desktop.mall.domain.usecase

import desktop.mall.domain.model.BaseModel
import desktop.mall.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainUseCase @Inject constructor(private val mainRepository: MainRepository) {

    fun getModelList() : Flow<List<BaseModel>> {
        return mainRepository.getModelList()
    }
}