//package com.example.domain.usecases
//
//import com.example.domain.executor.PostExecutorThread
//import com.example.domain.repositories.WordsRepository
//import io.reactivex.Completable
//
//class RemoveWordUseCase(private val wordRepository: WordsRepository, postExecutorThread: PostExecutorThread) : BaseUseCase(postExecutorThread) {
//
//    fun remove(wordPL: String): Completable {
//        return wordRepository.remove(wordPL)
//                ?.observeOn(postExecutorThread)
//                ?.subscribeOn(workExecutorThread)
//    }
//}
