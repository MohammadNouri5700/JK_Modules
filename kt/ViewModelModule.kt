package com.example.streamproject.di.module

import androidx.lifecycle.ViewModel
import com.example.streamproject.presenter.main.MainActivityViewModel
import com.example.streamproject.di.key.ViewModelKey
import com.example.streamproject.presenter.settings.SettingActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @ViewModelKey(MainActivityViewModel::class)
    @IntoMap
    abstract fun provide_MainActivityViewModel(vm: MainActivityViewModel): ViewModel


    @Binds
    @ViewModelKey(SettingActivityViewModel::class)
    @IntoMap
    abstract fun provide_SettingActivityViewModel(vm: SettingActivityViewModel): ViewModel

//    @Binds
//    @ViewModelKey(CameraViewModel::class)
//    @IntoMap
//    abstract fun provideCameraViewModel(vm: CameraViewModel): ViewModel
}