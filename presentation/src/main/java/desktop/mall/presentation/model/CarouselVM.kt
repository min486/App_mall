package desktop.mall.presentation.model

import desktop.mall.domain.model.Carousel
import desktop.mall.domain.model.Product
import desktop.mall.presentation.delegate.ProductDelegate

class CarouselVM(model: Carousel, private val productDelegate: ProductDelegate) : PresentationVM<Carousel>(model) {

    fun openCarouselProduct(product: Product) {
        productDelegate.openProduct(product)
    }
}