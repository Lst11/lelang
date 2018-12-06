package com.gmail.superarch.inject

import android.content.Context
import com.example.data.repositories.WordsRepositoryImpl
import com.example.domain.executor.PostExecutorThread
import com.example.domain.repositories.WordsRepository
import com.example.lena.finalapp.executor.UIThread
import com.gmail.name.data.net.RestService
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class DomainModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context = context

    @Provides
    @Singleton
    fun providePostExecutorThread(): PostExecutorThread = UIThread()


    @Provides
    fun provideWordsRepository(restService: RestService)
            : WordsRepository = WordsRepositoryImpl(restService)

    @Provides
    @Singleton
    fun provideRestService(@Named(URL_TRANSLATE_INJECT_NAME) serverUrl: String): RestService = RestService(serverUrl)

    @Provides
    @Named(URL_TRANSLATE_INJECT_NAME)
    @Singleton
    fun provideServerUrlDebug(): String = "https://translate.yandex.net/api/v1.5/tr.json/"
}