package com.example.lena.finalapp.presentation.screen.translator.items

import android.util.Log
import android.view.ViewGroup
import com.example.lena.finalapp.presentation.base.recycler.BaseRecyclerAdapter
import com.gmail.superarch.presentation.screen.student.list.items.WordItemViewModel

class WordItemAdapter : BaseRecyclerAdapter<String, WordItemViewModel>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): WordItemViewHolder {
        Log.e("aaa","WordItemAdapter - created view adapter" )
        return WordItemViewHolder.create(viewGroup, WordItemViewModel())
    }
}