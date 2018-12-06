package com.example.lena.finalapp.presentation.base

import android.support.v4.app.FragmentManager
import android.widget.Toast

abstract class BaseRouter<A : BaseActivity>(val activity: A) {
    fun goBack() {
        activity.onBackPressed()
    }

    fun showError(e: Throwable) {
        Toast.makeText(activity, "Error " + e.toString(),
                Toast.LENGTH_SHORT)
    }
}