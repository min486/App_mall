package desktop.mall.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import desktop.mall.data.db.dao.BasketDao
import desktop.mall.data.db.dao.HeartDao
import desktop.mall.data.db.dao.PurchaseDao
import desktop.mall.data.db.entity.BasketProductEntity
import desktop.mall.data.db.entity.HeartProductEntity
import desktop.mall.data.db.entity.PurchaseProductEntity

@Database(
    entities = [
        PurchaseProductEntity::class,
        HeartProductEntity::class,
        BasketProductEntity::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "AppDatabase.db"
    }

    abstract fun purchaseDao(): PurchaseDao

    abstract fun heartDao(): HeartDao

    abstract fun basketDao(): BasketDao
}