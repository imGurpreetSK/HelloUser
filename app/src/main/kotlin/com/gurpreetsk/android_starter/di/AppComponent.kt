package com.gurpreetsk.android_starter.di

import android.content.Context
import com.gurpreetsk.android_starter.MainApplication
import com.gurpreetsk.android_starter.di.modules.AppModule
import com.gurpreetsk.android_starter.di.modules.LogModule
import com.gurpreetsk.android_starter.di.modules.NetworkModule
import com.gurpreetsk.android_starter.di.modules.StorageModule
import com.gurpreetsk.android_starter.network.StarterApi
import com.gurpreetsk.android_starter.schedulers.AppSchedulers
import com.gurpreetsk.android_starter.storage.Repository
import com.gurpreetsk.android_starter.storage.db.AppDatabase
import com.gurpreetsk.android_starter.storage.prefs.AppSettings
import dagger.Component
import timber.log.Timber
import javax.inject.Singleton

@Singleton
@Component(modules = [
  AppModule::class,
  LogModule::class,
  NetworkModule::class,
  StorageModule::class
])
interface AppComponent {
  fun timberTree(): Timber.Tree

  fun schedulerProvider(): AppSchedulers
  fun appDatabase(): AppDatabase
  fun appSettings(): AppSettings
  fun repository(): Repository

  fun apiService(): StarterApi

  companion object {
    fun obtain(context: Context): AppComponent =
        (context.applicationContext as MainApplication).component()
  }
}
