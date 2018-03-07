package com.tomtom.tom.scalableapp.main

import com.tomtom.tom.domain.model.RepoDomainModel
import com.tomtom.tom.scalableapp.base.ActivityLifeCyclePresenter

interface MainActivityContract {

    interface View {
        fun updateScreen(list:List<RepoDomainModel>)
        fun updateTitle(title:String)
    }

    interface Presenter : ActivityLifeCyclePresenter
}