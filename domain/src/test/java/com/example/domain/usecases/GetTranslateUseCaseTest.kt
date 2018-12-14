package com.example.domain.usecases

import com.example.domain.entity.Word
import com.example.domain.executor.PostExecutorThread
import com.example.domain.repositories.WordsRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class GetTranslateUseCaseTest {
    @Mock
    lateinit var repository: WordsRepository

    private lateinit var usecase: GetTranslateUseCase

    inner class PostExecutorThreadTest : PostExecutorThread {
        override fun getScheduler(): Scheduler {
            return TestScheduler()
        }
    }

    @Before
    fun init() {
        usecase = GetTranslateUseCase(repository, PostExecutorThreadTest())
    }

    @Test
    fun testValidData() {
        val wordTest = Word("aaa", mutableListOf("bbb", "ccc"))

        Mockito.`when`(repository.getTranslate(wordTest)).thenReturn(
                Observable.just(Word("aaa", mutableListOf("bbb", "ccc", "ddd"))
                )
        )

//usecase.

    }

}