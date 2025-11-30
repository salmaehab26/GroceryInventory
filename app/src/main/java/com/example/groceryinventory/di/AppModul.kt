package com.example.groceryinventory.di
import android.content.Context
import androidx.room.Room
import com.example.groceryinventory.data.dataSource.localDataSource.AppDatabase
import com.example.groceryinventory.data.dataSource.localDataSource.DataSeeder
import com.example.groceryinventory.data.dataSource.localDataSource.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "grocery_database"
        ) .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideProductDao(database: AppDatabase): ProductDao {
        return database.productDao()
    }

    @Provides
    @Singleton
    fun provideDataSeeder(productDao: ProductDao): DataSeeder {
        return DataSeeder(productDao)
    }
}