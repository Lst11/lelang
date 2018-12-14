package com.example.lena.finalapp.presentation.screen.translator.items

import android.view.ViewGroup
import com.example.lena.finalapp.presentation.base.recycler.BaseRecyclerAdapter

class WordItemAdapter : BaseRecyclerAdapter<String, WordItemViewModel>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): WordItemViewHolder {
        return WordItemViewHolder.create(viewGroup, WordItemViewModel())
    }
}