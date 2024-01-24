package desktop.mall.data.datasource

import desktop.mall.domain.model.TestModel
import javax.inject.Inject

// api나 database를 통해 가져오는 부분
class TestDataSource @Inject constructor() {

    fun getTestModel(): TestModel {
        return TestModel("testModel")
    }
}