package com.example.android_hilt_template.di

import com.example.android_hilt_template.network.PostApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

data class NetworkConfig(
    val baseUrl: String
)


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkConfig(): NetworkConfig {
        return NetworkConfig(
            baseUrl = "https://jsonplaceholder.typicode.com/"
        )
    }

    @Provides
    @Singleton
    fun provideRetrofit(config: NetworkConfig): Retrofit {
        return Retrofit.Builder()
            .baseUrl(config.baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePostApi(retrofit: Retrofit): PostApiService {
        return retrofit.create(PostApiService::class.java)
    }
}