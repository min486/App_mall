package desktop.mall.domain.usecase

import desktop.mall.domain.model.TestModel
import desktop.mall.domain.repository.TestRepository
import javax.inject.Inject

class TestUseCase @Inject constructor(private val repository: TestRepository) {

    fun getTestModel() : TestModel {
        return repository.getTestModel()
    }
}