package desktop.mall.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import desktop.mall.domain.usecase.MainUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(useCase: MainUseCase) : ViewModel() {
    val productList = useCase.getProductList()

    fun openSearchForm() {
        println("openSearchForm")
    }
}