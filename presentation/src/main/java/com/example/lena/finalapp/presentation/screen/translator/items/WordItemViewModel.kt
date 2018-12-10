package com.gmail.superarch.presentation.screen.student.list.items

import android.databinding.ObservableField
import android.util.Log
import com.gmail.superarch.presentation.base.recycler.BaseItemViewModel

class WordItemViewModel : BaseItemViewModel<String>() {

    val wordRU = ObservableField<String>("")

    override fun bindItem(item: String, position: Int) {
        Log.e("aaa","WordItemViewModel - bindItem: $item" )
        wordRU.set(item)
    }
}