package desktop.mall.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import desktop.mall.domain.model.TestModel
import desktop.mall.domain.usecase.TestUseCase
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(private val userCase: TestUseCase) : ViewModel() {

    fun getTestModel(): TestModel {
        return userCase.getTestModel()
    }
}