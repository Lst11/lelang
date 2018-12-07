package com.gmail.superarch.presentation.screen.student.list.items

import android.databinding.ObservableField
import com.gmail.superarch.presentation.base.recycler.BaseItemViewModel

class WordTranslatedItemViewModel : BaseItemViewModel<String>() {

    val wordRU = ObservableField<String>("")

    override fun bindItem(item: String, position: Int) {
        wordRU.set(item)
    }
}