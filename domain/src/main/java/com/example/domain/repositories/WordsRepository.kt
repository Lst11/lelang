package com.example.domain.repositories

import com.example.domain.entity.Word
import io.reactivex.Completable
import io.reactivex.Observable

interface WordsRepository : BaseRepository {

//    fun get(wordPL: String): Observable<Word>
//
//    fun getAll(): Observable<List<Word>>

    fun getTranslate(wordPL: String): Observable<Word>?

//    fun add(wordPL: String): Completable
//
//    fun remove(wordPL: String): Completable
}