package desktop.mall.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import desktop.mall.data.repository.TestRepositoryImpl
import desktop.mall.domain.repository.TestRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindTestRepository(testRepositoryImpl: TestRepositoryImpl): TestRepository
}