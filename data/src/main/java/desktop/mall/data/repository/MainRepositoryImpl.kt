package desktop.mall.data.repository

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import desktop.mall.domain.model.Product
import desktop.mall.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.InputStreamReader
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(@ApplicationContext private val context: Context) : MainRepository {
    override fun getProductList(): Flow<List<Product>> = flow {
        val inputStream = context.assets.open("product_list.json")
        val inputStreamReader = InputStreamReader(inputStream)
        val jsonString = inputStreamReader.readText()
        val type = object : TypeToken<List<Product>>() { }.type

        emit(GsonBuilder().create().fromJson(jsonString, type))
    }
}