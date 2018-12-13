package com.example.lena.finalapp.presentation.screen.translator

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.databinding.ObservableField
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import android.view.View
import com.example.domain.entity.Word
import com.example.domain.usecases.AddWordUseCase
import com.example.domain.usecases.GetTranslateUseCase
import com.example.domain.usecases.RemoveWordUseCase
import com.example.lena.finalapp.presentation.base.BaseViewModel
import com.example.lena.finalapp.presentation.screen.MainRouter
import com.example.lena.finalapp.presentation.screen.translator.items.WordItemAdapter
import com.gmail.superarch.app.App
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class TranslateViewModel : BaseViewModel<MainRouter>() {

    @Inject
    lateinit var getTranslateUseCase: GetTranslateUseCase

    @Inject
    lateinit var addWordUseCase: AddWordUseCase

    @Inject
    lateinit var removeWordUseCase: RemoveWordUseCase

    var wordPl = ObservableField<String>("")
    var wordsRU: MutableList<String> = mutableListOf()

    val broadcastReceicer = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val wordFromMessage = intent.getStringExtra("message")
            Log.d("aaa", "TranslateViewModel got message: $wordFromMessage")

            if (wordFromMessage.equals("clickSave")) {
                wordsRU.add(wordFromMessage)
                addWordUseCase.add(Word(wordPl.get() ?: "", wordsRU))
            } else if (wordFromMessage.equals("clickRemove")) {
                wordsRU.remove(wordFromMessage)
                removeWordUseCase.remove(Word(wordPl.get() ?: "", wordsRU))
            }
        }
    }


    var adapter = WordItemAdapter()

    init {
        val intentFilter = IntentFilter()
        App.appComponent.inject(this)
        Log.d("aaa", "TranslateViewModel - added filters")
        intentFilter.addAction("clickSave")
        intentFilter.addAction("clickRemove")
        val receiver = LocalBroadcastManager.getInstance(App.instance.baseContext).registerReceiver(broadcastReceicer, IntentFilter())
//        registerReceiver(myBroadcastReceicer, intentFilter)
    }

    fun onClickTranslate(v: View) {
        adapter.cleanItems()
        Log.e("aaa", "TranslateViewModel onClickTranslate: " + wordPl.get())
        if (wordPl.get()?.isNotEmpty() == true) {
            getTranslateUseCase.getTranslate(wordPl.get() ?: "")
                    ?.subscribeBy(
                            onNext = {
                                Log.e("aaa", "TranslateViewModel - translated onNext: " + it.toString())
                                adapter.addItems(it.wordRU)
                                adapter.notifyDataSetChanged()
                            },
                            onError = {
                                Log.e("aaa", "TranslateViewModel - translated onError: " + it.toString())
                                router?.showError(it)
                            })
        }
    }

    fun onClickDelete(v: View) {
        Log.e("aaa", "TranslateViewModel onClickDelete")
        wordPl.set("")
        adapter.cleanItems()
    }

    override fun onCleared() {
        LocalBroadcastManager.getInstance(App.instance.baseContext).unregisterReceiver(broadcastReceicer)
        compositeDisposable.clear()
        super.onCleared()
    }
}