package com.example.data.repositories

import android.util.Log
import com.example.data.db.dao.WordDao
import com.example.data.utils.Transformer
import com.example.domain.entity.Word
import com.example.domain.repositories.WordsRepository
import com.gmail.name.data.net.RestService
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import transformToDomain
import javax.inject.Inject

class WordsRepositoryImpl @Inject constructor(val restService: RestService,
                                              val wordDao: WordDao) : WordsRepository {

    override fun getTranslate(wordPL: String): Observable<Word>? {
        Log.e("aaa", "WordsRepositoryImpl : getTranslate + $wordPL")
        val newWord = Word("aaa", mutableListOf("bbb", "ccc", "ddd", "eee", "jjj", "ggg", "hhh", "lll", "kkk"))
//        return restService.getTranslate(wordPL)
        return Observable.just(newWord)
    }

    fun saveAll() {
        val list = WordsListSingleton.list
        list.forEach {
            val wordDB = Transformer.transformDomainToDB(it)
            wordDao.insert(wordDB)
        }
    }

//    override fun get(wordPL: String): Observable<Word> {
//        //FIXME работа с БД
//        return get(wordPL)
//    }

    override fun getAll(): Observable<List<Word>>? {
        return wordDao.getAll()
                .flatMap { list ->
                    Flowable.just(list).map {
                        it.map {
                            it.transformToDomain()
                        }
                    }
                }
                .toObservable()
    }

    override fun add(word: Word): Completable? {
        Log.e("aaa", "WordsRepositoryImpl : added ${word.wordPL} - ${word.wordRU} ")
        wordDao.insert(Transformer.transformDomainToDB(word))
        return Completable.complete()
    }


    override fun remove(word: Word): Completable? {
        Log.e("aaa", "WordsRepositoryImpl : removed ${word.wordPL} - ${word.wordRU} ")
        wordDao.deleteByWordPL(word.wordPL)
        return Completable.complete()
    }

}

//    return wordDao.getAll()
//                .flatMap { list ->
//        Observable.just(list)
//                .map {
//                    it.map {
//                        it.transformToDomain()
//                    }
//                }
//    }

