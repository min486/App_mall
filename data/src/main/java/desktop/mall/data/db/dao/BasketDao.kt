package desktop.mall.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import desktop.mall.data.db.entity.BasketProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BasketDao {

    @Query("SELECT * FROM basket")
    fun getAll(): Flow<List<BasketProductEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: BasketProductEntity)

    // 장바구니 넣기 했을때, 기존 DB에 이미 있으면 count값 올려주는 함수
    // 단건으로 가져오는 부분이라 suspend 사용, SELECT해서 없으면 null 리턴
    @Query("SELECT * FROM basket WHERE productId=:id")
    suspend fun get(id: String): BasketProductEntity?

    @Query("DELETE FROM basket WHERE productId=:id")
    suspend fun delete(id: String)
}
