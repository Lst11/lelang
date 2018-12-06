//package com.example.domain.usecases
//
//import com.example.domain.entity.Word
//import com.example.domain.executor.PostExecutorThread
//import com.example.domain.repositories.WordsRepository
//import io.reactivex.Observable
//
//class GetWordUseCase(private val wordRepository: WordsRepository, postExecutorThread: PostExecutorThread) : BaseUseCase(postExecutorThread) {
//
//    fun get(wordPL: String): Observable<Word>? {
//        return wordRepository.get(wordPL)
//                ?.observeOn(postExecutorThread)
//                ?.subscribeOn(workExecutorThread)
//    }
//}
