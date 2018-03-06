package com.tomtom.tom.scalableapp.base

interface ActivityLifeCyclePresenter {
    fun onCreate()
    fun onResume()
    fun onPause()
    fun onDestroy()
    fun onStop()
}