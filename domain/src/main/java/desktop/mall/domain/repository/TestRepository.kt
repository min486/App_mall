package desktop.mall.domain.repository

import desktop.mall.domain.model.TestModel

interface TestRepository {
    fun getTestModel(): TestModel
}