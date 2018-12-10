package com.example.lena.finalapp.presentation.screen.translator.items

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.lena.finalapp.databinding.ItemWordTranslatedBinding
import com.gmail.superarch.presentation.base.recycler.BaseViewHolder
import com.gmail.superarch.presentation.screen.student.list.items.WordItemViewModel

class WordItemViewHolder(binding: ItemWordTranslatedBinding,
                         viewModel: WordItemViewModel)
    : BaseViewHolder<String,
        WordItemViewModel,
        ItemWordTranslatedBinding>(binding, viewModel) {

    companion object {
        fun create(parent: ViewGroup,
                   viewModel: WordItemViewModel): WordItemViewHolder {
            val binding = ItemWordTranslatedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            Log.e("aaa","WordItemViewHolder - created view holder" )
            return WordItemViewHolder(binding, viewModel)
        }
    }
}