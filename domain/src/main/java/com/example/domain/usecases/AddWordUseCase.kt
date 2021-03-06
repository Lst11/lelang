package com.example.domain.usecases

import com.example.domain.entity.Word
import com.example.domain.executor.PostExecutorThread
import com.example.domain.repositories.WordsRepository
import io.reactivex.Completable
import javax.inject.Inject

class AddWordUseCase @Inject constructor(private val wordRepository: WordsRepository, postExecutorThread: PostExecutorThread) : BaseUseCase(postExecutorThread) {

    fun add(word: Word): Completable? {
        return wordRepository.add(word)
                ?.observeOn(postExecutorThread)
                ?.subscribeOn(workExecutorThread)
    }
}
