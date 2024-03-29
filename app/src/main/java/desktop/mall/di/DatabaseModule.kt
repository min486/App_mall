package desktop.mall.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import desktop.mall.data.db.AppDatabase
import desktop.mall.data.db.dao.BasketDao
import desktop.mall.data.db.dao.HeartDao
import desktop.mall.data.db.dao.SearchDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideSearchDao(database: AppDatabase): SearchDao {
        return database.searchDao()
    }

    @Provides
    @Singleton
    fun provideHeartDao(database: AppDatabase): HeartDao {
        return database.heartDao()
    }

    @Provides
    @Singleton
    fun provideBasketDao(database: AppDatabase): BasketDao {
        return database.basketDao()
    }
}