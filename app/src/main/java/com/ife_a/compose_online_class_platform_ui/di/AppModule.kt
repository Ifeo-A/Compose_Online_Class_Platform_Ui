package com.ife_a.compose_online_class_platform_ui.di

import android.content.Context
import androidx.room.Room
import com.ife_a.compose_online_class_platform_ui.domain.CategoryRepository
import com.ife_a.compose_online_class_platform_ui.domain.CategoryRepositoryImpl
import com.ife_a.data.db.CategoryItemDataTypeConverter
import com.ife_a.data.db.ClassVideoEntityTypeConverter
import com.ife_a.data.db.OnlineClassDatabase
import com.ife_a.data.db.dao.CategoryEntityDao
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): OnlineClassDatabase {
        return Room.databaseBuilder(
            context,
            OnlineClassDatabase::class.java,
            "main_database"
        )
            .addTypeConverter(ClassVideoEntityTypeConverter(moshi = moshi))
            .addTypeConverter(CategoryItemDataTypeConverter(moshi = moshi))
            .fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideCategoryRepositoryDao(
        database: OnlineClassDatabase
    ): CategoryEntityDao {
        return database.categoryEntityDao()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class CategoriesModule {

    @Binds
    abstract fun provideCategoryRepository(categoryRepository: CategoryRepositoryImpl): CategoryRepository

}