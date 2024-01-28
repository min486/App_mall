package desktop.mall.data.repository

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import desktop.mall.data.deserializer.BaseModelDeserializer
import desktop.mall.domain.model.BaseModel
import desktop.mall.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.InputStreamReader
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(@ApplicationContext private val context: Context) : MainRepository {
    override fun getModelList(): Flow<List<BaseModel>> = flow {
        val inputStream = context.assets.open("product_list.json")
        val inputStreamReader = InputStreamReader(inputStream)
        val jsonString = inputStreamReader.readText()
        val type = object : TypeToken<List<BaseModel>>() {}.type

        emit(
            GsonBuilder()
                // BaseModel을 파싱하게 되었을때 gson에서 아래 TypeAdapter를 가지고 값을 가져옴
                .registerTypeAdapter(BaseModel::class.java, BaseModelDeserializer())
                .create()
                .fromJson(jsonString, type)
        )
    }
}