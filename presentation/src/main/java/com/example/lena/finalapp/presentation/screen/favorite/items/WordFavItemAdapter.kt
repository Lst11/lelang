package com.example.lena.finalapp.presentation.screen.favorite.items

import android.util.Log
import android.view.ViewGroup
import com.example.lena.finalapp.presentation.base.recycler.BaseRecyclerAdapter

class WordFavItemAdapter : BaseRecyclerAdapter<String, WordFavItemViewModel>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): WordFavItemViewHolder {
        Log.e("aaa","WordItemAdapter - created view adapter" )
        return WordFavItemViewHolder.create(viewGroup, WordFavItemViewModel())
    }
}