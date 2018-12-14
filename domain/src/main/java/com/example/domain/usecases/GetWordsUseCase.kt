package com.example.domain.usecases

import com.example.domain.entity.Word
import com.example.domain.executor.PostExecutorThread
import com.example.domain.repositories.WordsRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetWordsUseCase @Inject constructor(
        private val wordRepository: WordsRepository,
        postExecutorThread: PostExecutorThread)
    : BaseUseCase(postExecutorThread) {

    fun getAll(): Observable<List<Word>>? {
        return wordRepository.getAll()
                ?.observeOn(postExecutorThread)
                ?.subscribeOn(workExecutorThread)
    }
}
