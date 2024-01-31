package desktop.mall.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import desktop.mall.data.repository.AccountRepositoryImpl
import desktop.mall.data.repository.BasketRepositoryImpl
import desktop.mall.data.repository.CategoryRepositoryImpl
import desktop.mall.data.repository.LikeRepositoryImpl
import desktop.mall.data.repository.MainRepositoryImpl
import desktop.mall.data.repository.ProductDetailRepositoryImpl
import desktop.mall.data.repository.SearchRepositoryImpl
import desktop.mall.domain.repository.AccountRepository
import desktop.mall.domain.repository.BasketRepository
import desktop.mall.domain.repository.CategoryRepository
import desktop.mall.domain.repository.LikeRepository
import desktop.mall.domain.repository.MainRepository
import desktop.mall.domain.repository.ProductDetailRepository
import desktop.mall.domain.repository.SearchRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository

    @Binds
    @Singleton
    fun bindCategoryRepository(categoryRepositoryImpl: CategoryRepositoryImpl): CategoryRepository

    @Binds
    @Singleton
    fun bindProductDetailRepository(productDetailRepositoryImpl: ProductDetailRepositoryImpl): ProductDetailRepository

    @Binds
    @Singleton
    fun bindSearchRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository

    @Binds
    @Singleton
    fun bindLikeRepository(likeRepositoryImpl: LikeRepositoryImpl): LikeRepository

    @Binds
    @Singleton
    fun bindBasketRepository(basketRepositoryImpl: BasketRepositoryImpl): BasketRepository

    @Binds
    @Singleton
    fun bindAccountRepository(accountRepositoryImpl: AccountRepositoryImpl): AccountRepository
}