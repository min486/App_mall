package desktop.mall.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import desktop.mall.domain.model.Banner
import desktop.mall.domain.model.BannerList
import desktop.mall.domain.model.Category
import desktop.mall.domain.model.Product
import desktop.mall.domain.usecase.CategoryUseCase
import desktop.mall.domain.usecase.MainUseCase
import desktop.mall.presentation.ui.NavigationRouteName
import desktop.mall.presentation.utils.NavigationUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(mainUseCase: MainUseCase, categoryUseCase: CategoryUseCase) : ViewModel() {
    private val _columnCount = MutableStateFlow(2)
    val columnCount: StateFlow<Int> = _columnCount
    val modelList = mainUseCase.getModelList()
    val categories = categoryUseCase.getCategories()

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

    fun openCategory(navHostController: NavHostController, category: Category) {
        NavigationUtils.navigate(navHostController, NavigationRouteName.CATEGORY, category)
    }
}