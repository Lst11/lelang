package com.example.lena.finalapp.presentation.screen.favorite.items

import android.databinding.ObservableField
import com.example.domain.entity.Word
import com.example.lena.finalapp.presentation.base.recycler.BaseItemViewModel
import com.example.lena.finalapp.presentation.screen.favorite.WordDialog
import android.app.Activity
import android.view.View
import android.support.v7.app.AppCompatActivity


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

    fun onLongItemClick() {

//        MyDialogFragment.newInstance(
//                { di, whichButton -> doOkClicked(di, whichButton) },
//                { di, whichButton -> doCancelClicked(di, whichButton) }
//        ).show((view.getContext() as Activity).fragmentManager, "MyTag")
//        val ft = (view.getContext() as AppCompatActivity).supportFragmentManager
////        val ft = (view.getContext() as Activity).fragmentManager
//        WordDialog().show(ft, "dialog")

    }
}