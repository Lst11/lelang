package com.example.lena.finalapp.presentation.screen.translator.items

import android.databinding.ObservableField
import android.util.Log
import com.example.lena.finalapp.presentation.base.recycler.BaseItemViewModel

class WordItemViewModel : BaseItemViewModel<String>() {

    val wordRU = ObservableField<String>("")
    var isPressed = ObservableField<Boolean>(false)
    var clickCounter = 0

    override fun bindItem(item: String, position: Int, isUnique: Boolean) {
        wordRU.set(item)
        Log.e("aaa", "WordItemViewModel: bindItem() - isPressed:$isPressed ")
    }

    override fun onItemClick() {
        if (clickCounter++ % 2 == 0) isPressed.set(true)
        else isPressed.set(false)
        Log.e("aaa", "WordItemViewModel: onItemClick() isPressed:$isPressed ")
    }
}