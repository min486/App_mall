package desktop.mall.data.repository

import desktop.mall.data.datasource.ProductDataSource
import desktop.mall.domain.model.BaseModel
import desktop.mall.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val dataSource: ProductDataSource) : MainRepository {
    override fun getModelList(): Flow<List<BaseModel>> {
        return dataSource.getProducts()
    }
}