package desktop.mall.data.deserializer

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import desktop.mall.domain.model.Banner
import desktop.mall.domain.model.BannerList
import desktop.mall.domain.model.BaseModel
import desktop.mall.domain.model.Carousel
import desktop.mall.domain.model.ModelType
import desktop.mall.domain.model.Product
import desktop.mall.domain.model.Ranking
import java.lang.reflect.Type

// 수동으로 json 파일을 가져와서 파싱해주는 부분
class BaseModelDeserializer : JsonDeserializer<BaseModel> {
    companion object {
        private const val TYPE = "type"
    }

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): BaseModel {
        val root = json?.asJsonObject
        val gson = GsonBuilder().create()
        val typeString = root?.get(TYPE)?.asString ?: ""

        return when(ModelType.valueOf(typeString)) {
            ModelType.BANNER -> gson.fromJson(root, Banner::class.java)
            ModelType.PRODUCT -> gson.fromJson(root, Product::class.java)
            ModelType.BANNER_LIST -> gson.fromJson(root, BannerList::class.java)
            ModelType.CAROUSEL -> gson.fromJson(root, Carousel::class.java)
            ModelType.RANKING -> gson.fromJson(root, Ranking::class.java)
        }
    }
}