package com.example.lena.finalapp.presentation.screen

import android.support.v4.app.Fragment
import android.view.View
import com.example.lena.finalapp.R
import com.example.lena.finalapp.presentation.base.BaseRouter

class MainRouter(activity: MainActivity) : BaseRouter<MainActivity>(activity) {

    fun goToMenuItem(selectedFragment: Fragment) {
        val fragmentTransition = activity.supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.container, selectedFragment)
        fragmentTransition.commit()
    }
}