package desktop.mall.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import desktop.mall.data.db.converter.PurchaseConverter
import desktop.mall.domain.model.Category
import desktop.mall.domain.model.Price
import desktop.mall.domain.model.Product
import desktop.mall.domain.model.Shop

@Entity(tableName = "purchase")
@TypeConverters(PurchaseConverter::class)
data class PurchaseProductEntity(
    @PrimaryKey
    val productId: String,
    val productName: String,
    val imageUrl: String,
    val price: Price,
    val category: Category,
    val shop: Shop,
    val isNew: Boolean,
    val isFreeShipping: Boolean,
)

fun PurchaseProductEntity.toDomainModel(): Product {
    return Product(
        productId = productId,
        productName = productName,
        imageUrl = imageUrl,
        price = price,
        category = category,
        shop = shop,
        isNew = isNew,
        isFreeShipping = isFreeShipping
    )
}