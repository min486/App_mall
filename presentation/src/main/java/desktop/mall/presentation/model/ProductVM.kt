package desktop.mall.presentation.model

import desktop.mall.domain.model.Product
import desktop.mall.presentation.delegate.ProductDelegate

class ProductVM(model: Product, productDelegate: ProductDelegate) :
    PresentationVM<Product>(model), ProductDelegate by productDelegate