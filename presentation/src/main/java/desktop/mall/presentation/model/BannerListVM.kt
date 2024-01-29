package desktop.mall.presentation.model

import desktop.mall.domain.model.BannerList
import desktop.mall.presentation.delegate.BannerDelegate

class BannerListVM(model: BannerList, private val bannerDelegate: BannerDelegate) : PresentationVM<BannerList>(model) {

    fun openBannerList(bannerId: String) {
        bannerDelegate.openBanner(bannerId)
    }
}