package desktop.mall.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import desktop.mall.data.db.entity.HeartProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HeartDao {

    @Query("SELECT * FROM heart")
    fun getAll(): Flow<List<HeartProductEntity>>  // suspend -> Flow로 변경
                                                  // like값이 업데이트 될때마다 받아오기 위해

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: HeartProductEntity)

    @Query("DELETE FROM heart WHERE productId=:id")
    suspend fun delete(id: String)
}