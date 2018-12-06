package com.gmail.name.data.net

import android.util.Log
import com.example.data.entity.WordRequest
import com.example.data.utils.Transformer
import com.example.domain.entity.Word
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RestService(apiUrl: String) {

    private val restApi: RestApi

    init {
        val okHttpBuilder = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)

        val logging = HttpLoggingInterceptor()
        okHttpBuilder.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
                .baseUrl(apiUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(okHttpBuilder.build())
                .build()
        restApi = retrofit.create(RestApi::class.java)
    }

    fun getTranslate(wordPL: String): Observable<Word>? {
        val wordRequest = WordRequest(wordPL)
        return restApi.getTranslate(wordRequest.key,wordRequest.lang, wordRequest.wordPL)
                ?.observeOn(Schedulers.computation())
                ?.subscribeOn(Schedulers.io())
                ?.map { Transformer.transformResponseToDomain(wordPL,it)}
    }
}




