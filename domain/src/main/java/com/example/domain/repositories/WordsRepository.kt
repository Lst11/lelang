package com.example.domain.repositories

import com.example.domain.entity.Word
import io.reactivex.Completable
import io.reactivex.Observable

interface WordsRepository : BaseRepository {

    fun getTranslate(wordPL: String): Observable<Word>?

    fun getAll(): Observable<List<Word>>?

    fun add(word: Word): Completable?




//    fun get(wordPL: String): Observable<Word>

//    fun remove(wordPL: String): Completable
}