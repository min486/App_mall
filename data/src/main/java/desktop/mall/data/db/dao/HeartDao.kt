package desktop.mall.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import desktop.mall.data.db.entity.HeartProductEntity

@Dao
interface HeartDao {

    @Query("SELECT * FROM heart")
    suspend fun getAll(): List<HeartProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: HeartProductEntity)

    @Query("DELETE FROM heart WHERE productId=:id")
    suspend fun delete(id: String)
}