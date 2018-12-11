package com.example.data.repositories

import android.util.Log
import com.example.domain.entity.Word
import com.example.domain.repositories.WordsRepository
import com.gmail.name.data.net.RestService
import io.reactivex.Observable

class WordsRepositoryImpl(private val restService: RestService) : WordsRepository {

    val list: MutableList<Word> = mutableListOf(
            Word("cześć", mutableListOf("привет")),
            Word("chętnie", mutableListOf("охотно")),
            Word("cwiczenie", mutableListOf("упражнение")),
            Word("proszę", mutableListOf("прошу", "пожалуйста")),
            Word("prosty", mutableListOf("обычный", "простой")),
            Word("tak", mutableListOf("да")),
            Word("oczewiście", mutableListOf("конечно", "очевидно")),
            Word("nie", mutableListOf("нет")),
            Word("drobiazg", mutableListOf("мелочь")),
            Word("świetnie", mutableListOf("прекрасно")),
            Word("spoko", mutableListOf("спокойно")),
            Word("zły", mutableListOf("злой")),
            Word("kotek", mutableListOf("кот")))

    override fun getTranslate(wordPL: String): Observable<Word>? {
        Log.e("aaa", "WordsRepositoryImpl : getTranslate + $wordPL")
        return restService.getTranslate(wordPL)
    }

//    override fun get(wordPL: String): Observable<Word> {
//        //FIXME работа с БД
//        return get(wordPL)
//    }

    override fun getAll(): Observable<List<Word>> {


        return Observable.just(list)
    }


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