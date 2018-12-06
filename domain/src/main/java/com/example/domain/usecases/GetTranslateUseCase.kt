package com.example.domain.usecases

import com.example.domain.entity.Word
import com.example.domain.executor.PostExecutorThread
import com.example.domain.repositories.WordsRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetTranslateUseCase @Inject constructor (private val wordRepository: WordsRepository, postExecutorThread: PostExecutorThread) : BaseUseCase(postExecutorThread) {

    fun getTranslate(wordPL: String): Observable<Word>? {
        return wordRepository.getTranslate(wordPL)
                ?.observeOn(postExecutorThread)
                ?.subscribeOn(workExecutorThread)
    }
}
