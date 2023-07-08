package com.example.streamproject.di.module

import android.content.Context
import com.example.streamproject.repository.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton


@Module
class DataBaseModule {



    @Provides
    @Singleton
    fun providesApplicationScope() = CoroutineScope(SupervisorJob())




    @Provides
    @Singleton
    fun provideDatabase(context: Context,scope:CoroutineScope) = AppDatabase.getDatabase(context,scope)



    @Provides
    @Singleton
    fun provideUserDao(db: AppDatabase) = db.dataEntryDao()



    @Provides
    @Singleton
    fun providevideoSettingDao(db: AppDatabase) = db.videoSettingDao()

    @Provides
    @Singleton
    fun provideAudioSettingDao(db: AppDatabase) = db.audioSettingDao()


    @Provides
    @Singleton
    fun providefileDao(db: AppDatabase) = db.fileDao()



    @Provides
    @Singleton
    fun provideSystemSettingDao(db: AppDatabase) = db.systemSettingDao()


//    @Singleton
//    @Provides
//    fun provideVideoSettingDao(db: AppDatabase) = db.createVideoSettingDao()

}