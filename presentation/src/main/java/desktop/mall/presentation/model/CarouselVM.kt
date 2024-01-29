package desktop.mall.presentation.model

import androidx.navigation.NavHostController
import desktop.mall.domain.model.Carousel
import desktop.mall.domain.model.Product
import desktop.mall.presentation.delegate.ProductDelegate

class CarouselVM(model: Carousel, private val productDelegate: ProductDelegate) : PresentationVM<Carousel>(model) {

    fun openCarouselProduct(navHostController: NavHostController, product: Product) {
        productDelegate.openProduct(navHostController, product)
    }
}