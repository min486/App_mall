package desktop.mall.data.repository

import desktop.mall.data.datasource.ProductDataSource
import desktop.mall.data.db.dao.SearchDao
import desktop.mall.data.db.entity.SearchKeywordEntity
import desktop.mall.data.db.entity.toDomain
import desktop.mall.domain.model.Product
import desktop.mall.domain.model.SearchKeyword
import desktop.mall.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val dataSource: ProductDataSource,
    private val searchDao: SearchDao
) : SearchRepository {

    override suspend fun search(searchKeyword: SearchKeyword): Flow<List<Product>> {
        searchDao.insert(SearchKeywordEntity(searchKeyword.keyword))  // 검색 히스토리 남기기

        return dataSource.getProducts().map { list ->
            list.filter { it.productName.contains(searchKeyword.keyword) }  // 검색한 keyword와 동일한부분의 텍스트가 있는지 확인
        }
    }

    override fun getSearchKeywords(): Flow<List<SearchKeyword>> {
        // SearchKeywordEntity를 domain에서 사용할 수 있는 SearchKeyword로 변경
        // domain은 data layer를 참조하고 있지 않기 때문에
        return searchDao.getAll().map { it.map { entity -> entity.toDomain() } }
    }
}