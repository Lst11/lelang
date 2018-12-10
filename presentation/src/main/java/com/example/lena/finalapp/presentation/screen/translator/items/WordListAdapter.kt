//package com.example.lena.finalapp.presentation.screen.translator.items
//
//import android.databinding.DataBindingUtil
//import android.support.v7.widget.RecyclerView
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import com.example.lena.finalapp.R
//import com.example.lena.finalapp.databinding.ItemWordTranslatedBinding
//
//class WordListAdapter : RecyclerView.Adapter<WordListAdapter.Holder>() {
//
//    private var list: List<String> = mutableListOf()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//        val layoutInflater = LayoutInflater.from(parent.getContext())
//        val binding = DataBindingUtil.inflate<ItemWordTranslatedBinding>(
//                layoutInflater, R.layout.item_word_translated, parent, false
//        )
//        return Holder(binding)
//    }
//
//    override fun getItemCount(): Int = list.size
//
//    override fun onBindViewHolder(holder: Holder, position: Int) {
//        holder.bind(list.elementAt(position))
//    }
//
//    inner class Holder(val binding: ItemWordTranslatedBinding) : RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(word: String) {
//            Log.e("aaa","WordListAdapter - Holder.bind: $word")
//            binding.wordTextView.text = word
//            binding.executePendingBindings()
//        }
//    }
//
//    fun setData(list: List<String>) {
//        this.list = list
//
//    }
//}
