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
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetWordsUseCaseTest {

    @Mock
    lateinit var repository: WordsRepository

    private lateinit var usecase: GetWordsUseCase

    inner class PostExecutorThreadTest : PostExecutorThread {
        override fun getScheduler(): Scheduler {
            return TestScheduler()
        }
    }

    @Before
    fun init() {
        usecase = GetWordsUseCase(repository, PostExecutorThreadTest())
    }

    @Test
    fun testValidData() {

        `when`(repository.getAll()).thenReturn(
                Observable.just(mutableListOf(
                        Word("111", mutableListOf("111")),
                        Word("222", mutableListOf("222")),
                        Word("333", mutableListOf("333"))
                ))
        )

        usecase.getAll()
                ?.subscribe {
                    assert(it.size == 3)
                }

    }


}