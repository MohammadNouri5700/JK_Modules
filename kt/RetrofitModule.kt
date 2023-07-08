package com.example.barapp.di.module

import android.content.Context
import com.example.streamproject.di.module.PreferencesModule
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
class RetrofitModule {


    @Provides
    fun provideRetrofit(gson: Gson,okHttpClient: OkHttpClient) : Retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/api/")
        .client(okHttpClient)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()


    @Provides
    fun provideOkHttp(context: Context, preferences: PreferencesModule):OkHttpClient{
        val okHttpClient = OkHttpClient()
            .newBuilder() //httpLogging interceptor for logging network requests
            .build()
        return okHttpClient
    }

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()



}





