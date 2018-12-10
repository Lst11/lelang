package com.example.lena.finalapp.presentation.screen.favorite.items

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.lena.finalapp.databinding.ItemWordFavoriteBinding
import com.example.lena.finalapp.databinding.ItemWordTranslatedBinding
import com.gmail.superarch.presentation.base.recycler.BaseViewHolder

class WordFavItemViewHolder(binding: ItemWordFavoriteBinding,
                         viewModel: WordFavItemViewModel)
    : BaseViewHolder<String,
        WordFavItemViewModel,
        ItemWordFavoriteBinding>(binding, viewModel) {

    companion object {
        fun create(parent: ViewGroup,
                   viewModel: WordFavItemViewModel): WordFavItemViewHolder {
            val binding = ItemWordFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            Log.e("aaa","WordItemViewHolder - created view holder" )
            return WordFavItemViewHolder(binding, viewModel)
        }
    }
}