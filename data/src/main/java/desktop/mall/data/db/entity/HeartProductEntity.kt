package desktop.mall.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import desktop.mall.data.db.converter.HeartConverter
import desktop.mall.domain.model.Category
import desktop.mall.domain.model.Price
import desktop.mall.domain.model.Product
import desktop.mall.domain.model.Shop

@Entity(tableName = "heart")
@TypeConverters(HeartConverter::class)
data class HeartProductEntity(
    @PrimaryKey
    val productId: String,
    val productName: String,
    val imageUrl: String,
    val price: Price,
    val category: Category,
    val shop: Shop,
    val isNew: Boolean,
    val isFreeShipping: Boolean,
    val isLike: Boolean
)

fun HeartProductEntity.toDomainModel(): Product {
    return Product(
        productId = productId,
        productName = productName,
        imageUrl = imageUrl,
        price = price,
        category = category,
        shop = shop,
        isNew = isNew,
        isFreeShipping = isFreeShipping,
        isLike = isLike
    )
}

fun Product.toHeartProductEntity(): HeartProductEntity {
    return HeartProductEntity(
        productId = productId,
        productName = productName,
        imageUrl = imageUrl,
        price = price,
        category = category,
        shop = shop,
        isNew = isNew,
        isFreeShipping = isFreeShipping,
        isLike = isLike
    )
}