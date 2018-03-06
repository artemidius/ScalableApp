package com.tomtom.tom.scalableapp.main

import android.os.Bundle
import android.util.Log
import com.tomtom.tom.scalableapp.R
import com.tomtom.tom.scalableapp.base.BaseActivity

class MainActivity : BaseActivity(), MainActivityContract.View {

    val tag = this.javaClass.simpleName

    override fun updateScreen() {
        Log.d(tag, "Presenter triggered updateScreen")
    }

    lateinit var presenter:MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainActivityPresenterImpl(this)
        presenter.onCreate()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

}
