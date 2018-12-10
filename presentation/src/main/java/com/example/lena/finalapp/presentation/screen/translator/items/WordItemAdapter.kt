package com.example.lena.finalapp.presentation.screen.translator.items

import android.util.Log
import android.view.ViewGroup
import com.example.lena.finalapp.presentation.base.recycler.BaseRecyclerAdapter
import com.example.lena.finalapp.presentation.screen.favorite.items.WordItemViewModel

class WordItemAdapter : BaseRecyclerAdapter<String, WordItemViewModel>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): com.example.lena.finalapp.presentation.screen.favorite.items.WordItemViewHolder {
        Log.e("aaa","WordItemAdapter - created view adapter" )
        return WordItemViewHolder.create(viewGroup, WordItemViewModel())
    }
}