package com.example.streamproject.di.module

import android.util.Log
import android.widget.Toast
import com.example.streamproject.presenter.serialinterpreter.ComBean
import com.example.streamproject.presenter.serialinterpreter.SerialHelper
import dagger.Module
import dagger.Provides
import java.io.UnsupportedEncodingException
import javax.inject.Singleton


@Module
class SerialModule {


//    @Singleton
//    @Provides
//    fun provideSerial(): SerialHelper = object : SerialHelper("/dev/pts/3", 9600) {
//        override fun onDataReceived(comBean: ComBean) {
//
//
//            Log.e("SERIAL",comBean.toString())
//
//        }
//    }

}