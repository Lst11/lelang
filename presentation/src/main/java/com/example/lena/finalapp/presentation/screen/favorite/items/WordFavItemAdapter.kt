package com.example.lena.finalapp.presentation.screen.favorite.items

import android.util.Log
import android.view.ViewGroup
import com.example.domain.entity.Word
import com.example.lena.finalapp.presentation.base.recycler.BaseRecyclerAdapter
import com.gmail.superarch.presentation.base.recycler.BaseViewHolder

class WordFavItemAdapter : BaseRecyclerAdapter<Word, WordFavItemViewModel>() {

    override fun onBindViewHolder(holder: BaseViewHolder<Word, WordFavItemViewModel, *>, position: Int) {
        var isUnique = true
        if (position > 0) {
            val letterPrevious = itemList[position - 1].wordPL.first().toUpperCase()
            val letterThis = itemList[position].wordPL.first().toUpperCase()
            if (letterPrevious == letterThis) isUnique = false
            Log.e("aaa", "Unique word ${itemList[position].wordPL}: $isUnique")
            Log.e("aaa", "previous: $letterPrevious; letterThis: $letterThis")
        }
        holder.bind(itemList[position], position, isUnique)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): WordFavItemViewHolder {
        Log.e("aaa", "WordFavItemAdapter - created view adapter")
        return WordFavItemViewHolder.create(viewGroup, WordFavItemViewModel())
    }
}