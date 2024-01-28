package desktop.mall.domain.repository

import desktop.mall.domain.model.BaseModel
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getModelList(): Flow<List<BaseModel>>
}