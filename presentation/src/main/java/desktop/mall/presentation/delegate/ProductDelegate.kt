package desktop.mall.presentation.delegate

import androidx.navigation.NavHostController
import desktop.mall.domain.model.Product

interface ProductDelegate {
    fun openProduct(navHostController: NavHostController, product: Product)
}