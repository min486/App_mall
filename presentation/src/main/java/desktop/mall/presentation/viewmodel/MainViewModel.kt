package desktop.mall.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import desktop.mall.domain.model.Banner
import desktop.mall.domain.model.BannerList
import desktop.mall.domain.model.BaseModel
import desktop.mall.domain.model.Carousel
import desktop.mall.domain.model.Category
import desktop.mall.domain.model.Product
import desktop.mall.domain.model.Ranking
import desktop.mall.domain.usecase.CategoryUseCase
import desktop.mall.domain.usecase.LikeUseCase
import desktop.mall.domain.usecase.MainUseCase
import desktop.mall.presentation.delegate.BannerDelegate
import desktop.mall.presentation.delegate.CategoryDelegate
import desktop.mall.presentation.delegate.ProductDelegate
import desktop.mall.presentation.model.BannerListVM
import desktop.mall.presentation.model.BannerVM
import desktop.mall.presentation.model.CarouselVM
import desktop.mall.presentation.model.PresentationVM
import desktop.mall.presentation.model.ProductVM
import desktop.mall.presentation.model.RankingVM
import desktop.mall.presentation.ui.NavigationRouteName
import desktop.mall.presentation.utils.NavigationUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCase: MainUseCase,
    categoryUseCase: CategoryUseCase,
    likeUseCase: LikeUseCase
) : ViewModel(), ProductDelegate, BannerDelegate, CategoryDelegate {
    private val _columnCount = MutableStateFlow(2)
    val columnCount: StateFlow<Int> = _columnCount
    val modelList = mainUseCase.getModelList().map(::convertToPresentationVM)
    val categories = categoryUseCase.getCategories()
    // 좋아요 누른 Product 리스트(데이터들)를 가져옴
    val likeProducts = likeUseCase.getLikeProducts().map(::convertToPresentationVM)

    fun openSearchForm(navHostController: NavHostController) {
        NavigationUtils.navigate(navHostController, NavigationRouteName.SEARCH)
    }

    fun openBasket(navHostController: NavHostController) {
        NavigationUtils.navigate(navHostController, NavigationRouteName.BASKET)
    }

    fun updateColumnCount(count: Int) {
        viewModelScope.launch {
            _columnCount.emit(count)
        }
    }

    override fun openProduct(navHostController: NavHostController, product: Product) {
        NavigationUtils.navigate(navHostController, NavigationRouteName.PRODUCT_DETAIL, product)
    }

    override fun likeProduct(product: Product) {
        viewModelScope.launch {
            mainUseCase.likeProduct(product)
        }
    }

    override fun openBanner(bannerId: String) {
        TODO("Not yet implemented")
    }

    override fun openCategory(navHostController: NavHostController, category: Category) {
        NavigationUtils.navigate(navHostController, NavigationRouteName.CATEGORY, category)
    }

    private fun convertToPresentationVM(list: List<BaseModel>): List<PresentationVM<out BaseModel>> {
        return list.map { model ->
            when (model) {
                is Product -> ProductVM(model, this)
                is Ranking -> RankingVM(model, this)
                is Carousel -> CarouselVM(model, this)
                is Banner -> BannerVM(model, this)
                is BannerList -> BannerListVM(model, this)
            }
        }
    }
}