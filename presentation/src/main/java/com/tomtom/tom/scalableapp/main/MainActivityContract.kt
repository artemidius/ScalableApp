package com.tomtom.tom.scalableapp.main

import com.tomtom.tom.scalableapp.base.ActivityLifeCyclePresenter

interface MainActivityContract {

    interface View {
        fun updateScreen()
    }

    interface Presenter : ActivityLifeCyclePresenter
}