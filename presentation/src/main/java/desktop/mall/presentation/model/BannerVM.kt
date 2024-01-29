package desktop.mall.presentation.model

import desktop.mall.domain.model.Banner
import desktop.mall.presentation.delegate.BannerDelegate

class BannerVM(model: Banner, bannerDelegate: BannerDelegate)
    : PresentationVM<Banner>(model), BannerDelegate by bannerDelegate