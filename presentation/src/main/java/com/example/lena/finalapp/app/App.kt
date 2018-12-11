package com.gmail.superarch.app

import android.app.Application
import android.support.v7.app.AppCompatDelegate
import com.gmail.superarch.inject.AppComponent
import com.gmail.superarch.inject.DaggerAppComponent
import com.gmail.superarch.inject.DomainModule


class App : Application() {

    companion object {
        lateinit var instance: App
        @JvmStatic lateinit var appComponent: AppComponent
    }

    init {
        instance = this
    }

    override fun onCreate() {
//        appComponent.inject(this)
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .domainModule(DomainModule(this))
                .build()

//        Fabric.with(this, Crashlytics())
    }
}