package com.example.lena.finalapp.presentation.screen.favorite.items

import android.databinding.ObservableField
import com.gmail.superarch.presentation.base.recycler.BaseItemViewModel

class WordFavItemViewModel : BaseItemViewModel<String>() {

    val wordRU = ObservableField<String>("")

    override fun bindItem(item: String, position: Int) {
        wordRU.set(item)
    }
}