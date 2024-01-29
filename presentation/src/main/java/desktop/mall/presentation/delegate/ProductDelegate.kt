package desktop.mall.presentation.delegate

import desktop.mall.domain.model.Product

interface ProductDelegate {
    fun openProduct(product: Product)
}