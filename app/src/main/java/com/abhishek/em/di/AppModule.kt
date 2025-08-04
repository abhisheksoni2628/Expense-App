package com.abhishek.em.di

import android.content.Context
import androidx.room.Room
import com.abhishek.em.data.local.AppDatabase
import com.abhishek.em.data.local.ExpenseDao
import com.abhishek.em.data.remote.ApiService
import com.abhishek.em.domain.repository.ExpenseRepository
import com.abhishek.em.domain.repository.ExpenseRepositoryImpl
import com.abhishek.em.domain.repository.PostRepository
import com.abhishek.em.domain.repository.PostRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApiService(): ApiService {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl("http://192.168.148.50:5000")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }


    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) : AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "expense_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideExpenseDao(db: AppDatabase): ExpenseDao = db.expenseDao()


    @Provides
    fun providePostRepository(api: ApiService): PostRepository {
        return PostRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideExpenseRepository(expenseDao: ExpenseDao): ExpenseRepository {
        return ExpenseRepositoryImpl(expenseDao)
    }


}