package desktop.mall.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import desktop.mall.data.repository.MainRepositoryImpl
import desktop.mall.domain.repository.MainRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindTestRepository(testRepositoryImpl: TestRepositoryImpl): TestRepository

    @Binds
    @Singleton
    fun bindMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository
}