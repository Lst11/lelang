package com.example.lena.finalapp.presentation.screen.translator.items

import android.content.Intent
import android.databinding.ObservableField
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import com.example.lena.finalapp.presentation.base.recycler.BaseItemViewModel
import com.gmail.superarch.app.App


class WordItemViewModel : BaseItemViewModel<String>() {

    val wordRU = ObservableField<String>("")
    var isPressed = ObservableField<Boolean>(false)
    var clickCounter = 0

    override fun bindItem(item: String, position: Int, isUnique: Boolean) {
        wordRU.set(item)
        Log.e("aaa", "WordItemViewModel: bindItem() - isPressed:$isPressed ")
    }

    override fun onItemClick() {
        if (clickCounter++ % 2 == 0) {
            isPressed.set(true)
            sendMessageSave()
        } else {
            isPressed.set(false)
            sendMessageRemove()
        }
        Log.e("aaa", "WordItemViewModel: onItemClick() isPressed:$isPressed ")

    }


    private fun sendMessageSave() {
        Log.d("aaa", "Broadcasting message")
        val intent = Intent("clickSave")
        intent.putExtra("message", wordRU.get())
        LocalBroadcastManager.getInstance(App.instance.baseContext).sendBroadcast(intent)
    }

    private fun sendMessageRemove() {
        Log.d("aaa", "Broadcasting message")
        val intent = Intent("clickRemove")
        intent.putExtra("message", wordRU.get())
        LocalBroadcastManager.getInstance(App.instance.baseContext).sendBroadcast(intent)
    }

}