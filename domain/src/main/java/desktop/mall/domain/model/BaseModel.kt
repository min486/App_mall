package desktop.mall.domain.model

abstract class BaseModel {
    abstract val type: ModelType
}

enum class ModelType {
    PRODUCT,
    BANNER,
    BANNER_LIST,
}