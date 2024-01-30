package desktop.mall.domain.usecase

import desktop.mall.domain.model.Product
import desktop.mall.domain.model.SearchKeyword
import desktop.mall.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val searchRepository: SearchRepository) {

    suspend fun search(keyword: SearchKeyword): Flow<List<Product>> {
        return searchRepository.search(keyword)
    }

    fun getSearchKeywords(): Flow<List<SearchKeyword>> {
        return searchRepository.getSearchKeywords()
    }
}