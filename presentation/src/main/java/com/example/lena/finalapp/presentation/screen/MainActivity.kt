package com.example.lena.finalapp.presentation.screen

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.Window
import com.example.lena.finalapp.R
import com.example.lena.finalapp.databinding.ActivityMainBinding
import com.example.lena.finalapp.presentation.base.BaseMvvmActivity
import com.example.lena.finalapp.presentation.screen.all.AllWordsFragment
import com.example.lena.finalapp.presentation.screen.favorite.FavoriteWordsFragment
import com.example.lena.finalapp.presentation.screen.translator.TranslateFragment


class MainActivity : BaseMvvmActivity<MainViewModel, MainRouter, ActivityMainBinding>() {

    override fun prodiveViewModel(): MainViewModel {
        return ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun provideRouter(): MainRouter = MainRouter(this)

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        router.goToMenuItem(TranslateFragment())

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNav.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment = TranslateFragment()
            when (item.itemId) {
                R.id.transtaleButton -> selectedFragment = TranslateFragment()
                R.id.allWordsButton -> selectedFragment = AllWordsFragment()
                R.id.favoriteWordsButton -> selectedFragment = FavoriteWordsFragment()
            }
            router.goToMenuItem(selectedFragment)
            return@setOnNavigationItemSelectedListener true

//            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
//            setContentView(R.layout.activity_main)
        }
    }
}


