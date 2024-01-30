package desktop.mall.domain.repository

import desktop.mall.domain.model.Product
import desktop.mall.domain.model.SearchKeyword
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    suspend fun search(searchKeyword: SearchKeyword): Flow<List<Product>>  // 검색결과 가져오는 곳

    fun getSearchKeywords(): Flow<List<SearchKeyword>>  // 검색어 가져오는 곳
}