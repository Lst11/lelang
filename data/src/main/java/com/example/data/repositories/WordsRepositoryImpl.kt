package com.example.data.repositories

import android.util.Log
import com.example.domain.entity.Word
import com.example.domain.repositories.WordsRepository
import com.gmail.name.data.net.RestService
import io.reactivex.Observable

class WordsRepositoryImpl(private val restService: RestService) : WordsRepository {

    override fun getTranslate(wordPL: String): Observable<Word>? {
        Log.e("aaa", "WordsRepositoryImpl : getTranslate + $wordPL")
        return restService.getTranslate(wordPL)
    }

//    override fun get(wordPL: String): Observable<Word> {
//        //FIXME работа с БД
//        return get(wordPL)
//    }
//
//    override fun getAll(): Observable<List<Word>> {
//        //FIXME работа с БД
//        return getAll()
//    }


//    override fun add(wordPL: String): Completable {
//        //FIXME работа с БД
////        return add(wordPL)
//        return Completable.complete()
//    }
//
//    override fun remove(wordPL: String): Completable {
//        //FIXME работа с БД
////        return deletePerson(wordPL)
//        return Completable.complete()
//    }
}