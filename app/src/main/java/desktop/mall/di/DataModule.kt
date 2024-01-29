package desktop.mall.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import desktop.mall.data.repository.CategoryRepositoryImpl
import desktop.mall.data.repository.MainRepositoryImpl
import desktop.mall.data.repository.ProductDetailRepositoryImpl
import desktop.mall.domain.repository.CategoryRepository
import desktop.mall.domain.repository.MainRepository
import desktop.mall.domain.repository.ProductDetailRepository
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
}