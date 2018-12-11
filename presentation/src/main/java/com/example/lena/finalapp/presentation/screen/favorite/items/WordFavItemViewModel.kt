package com.example.lena.finalapp.presentation.screen.favorite.items

import android.databinding.ObservableField
import com.example.domain.entity.Word
import com.example.lena.finalapp.presentation.base.recycler.BaseItemViewModel

class WordFavItemViewModel : BaseItemViewModel<Word>() {

    var visability = ObservableField<Boolean>(false)
    val letter = ObservableField<String>("")
    val wordPL = ObservableField<String>("")

    override fun bindItem(word: Word, position: Int, isUnique: Boolean) {
        visability.set(isUnique)
        if (isUnique) {
            val char = word.wordPL.first().toString().toUpperCase()
            letter.set(char)
        }
        wordPL.set(word.wordPL)
    }
}