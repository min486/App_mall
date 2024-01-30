package desktop.mall.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import desktop.mall.data.db.dao.BasketDao
import desktop.mall.data.db.dao.HeartDao
import desktop.mall.data.db.dao.PurchaseDao
import desktop.mall.data.db.dao.SearchDao
import desktop.mall.data.db.entity.BasketProductEntity
import desktop.mall.data.db.entity.HeartProductEntity
import desktop.mall.data.db.entity.PurchaseProductEntity
import desktop.mall.data.db.entity.SearchKeywordEntity

@Database(
    entities = [
        PurchaseProductEntity::class,
        HeartProductEntity::class,
        BasketProductEntity::class,
        SearchKeywordEntity::class,
    ],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "AppDatabase.db"
    }

    abstract fun purchaseDao(): PurchaseDao

    abstract fun heartDao(): HeartDao

    abstract fun basketDao(): BasketDao
    abstract fun searchDao(): SearchDao
}