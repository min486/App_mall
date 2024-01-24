package desktop.mall.data.repository

import desktop.mall.data.datasource.TestDataSource
import desktop.mall.domain.model.TestModel
import desktop.mall.domain.repository.TestRepository
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(private val dataSource: TestDataSource) : TestRepository {
    override fun getTestModel(): TestModel {
        return dataSource.getTestModel()
    }
}