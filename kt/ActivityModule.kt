package com.example.streamproject.di.module

import com.example.streamproject.presenter.settings.SettingActivity
import com.example.streamproject.presenter.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [])
    abstract fun provide_MainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [])
    abstract fun provide_SettingActivity(): SettingActivity

}