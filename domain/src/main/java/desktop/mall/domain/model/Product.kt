package desktop.mall.domain.model

data class Product(
    val productId: String,
    val productName: String,
    val imageUrl: String,
    val price: Price,
    val category: Category,
    val shop: Shop,
    val isLike: Boolean,
    val isNew: Boolean,
    val isFreeShipping: Boolean,
    override val type: ModelType = ModelType.PRODUCT,
) : BaseModel()