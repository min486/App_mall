package desktop.mall.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import desktop.mall.domain.model.Banner
import desktop.mall.domain.model.BannerList
import desktop.mall.domain.model.Product
import desktop.mall.domain.usecase.MainUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(useCase: MainUseCase) : ViewModel() {
    private val _columnCount = MutableStateFlow(2)
    val columnCount: StateFlow<Int> = _columnCount
    val modelList = useCase.getModelList()

    fun openSearchForm() {
        println("openSearchForm")
    }

    fun updateColumnCount(count: Int) {
        viewModelScope.launch {
            _columnCount.emit(count)
        }
    }

    fun openProduct(product: Product) {

    }

    fun openCarouselProduct(product: Product) {

    }

    fun openRankingProduct(product: Product) {

    }

    fun openBanner(banner: Banner) {

    }

    fun openBannerList(bannerList: BannerList) {

    }
}