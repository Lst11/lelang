package com.example.lena.finalapp.presentation.base.recycler

import android.util.Log

abstract class BaseItemViewModel<Entity> {

    abstract fun bindItem(item: Entity, position: Int, isUnique: Boolean)

    open fun onItemClick() {
        Log.e("aaa", "BaseItemViewModel: onItemClick() ")
    }
}