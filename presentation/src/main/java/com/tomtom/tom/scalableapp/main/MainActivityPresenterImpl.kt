package com.tomtom.tom.scalableapp.main

import android.util.Log
import com.tomtom.tom.data.BackendRepo
import com.tomtom.tom.domain.Interactor
import com.tomtom.tom.domain.RetrieveUserReposUseCase
import com.tomtom.tom.domain.RetrieveUserReposUseCaseImpl
import com.tomtom.tom.domain.model.RepoDomainModel

class MainActivityPresenterImpl(mainActivity: MainActivity):MainActivityContract.Presenter, Interactor.Presentation {

    override fun onRepositoriesRetrieved(repos: List<RepoDomainModel>) {
        Log.d(tag, "Retrieved ${repos.size} repos")
        for (repo in repos) {
            Log.d(tag, "ID: ${repo.id}; Name: ${repo.name}")
        }
        view.updateScreen(repos)
    }

    val tag = this.javaClass.simpleName
    val constantUser = "mralexgray"
    val view:MainActivityContract.View = mainActivity
    val dataInteractor:Interactor.Data = BackendRepo()

    val retrieveReposUseCase:RetrieveUserReposUseCase = RetrieveUserReposUseCaseImpl()

    override fun onResume()   {
        Log.d(tag, "Activity triggered onResume()")
        val boundary = this
        Thread {
            retrieveReposUseCase.run(constantUser, dataInteractor, boundary)
        }.start()
    }

    override fun onCreate()   {  Log.d(tag, "Activity triggered onCreate()")    }
    override fun onPause()    {  Log.d(tag, "Activity triggered onPause()")     }
    override fun onDestroy()  {  Log.d(tag, "Activity triggered onDestroy()")   }
    override fun onStop()     {  Log.d(tag, "Activity triggered onStop()")      }

}