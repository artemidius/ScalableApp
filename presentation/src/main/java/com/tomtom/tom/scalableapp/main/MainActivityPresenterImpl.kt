package com.tomtom.tom.scalableapp.main

import android.util.Log
import com.tomtom.tom.data.BackendRepo
import com.tomtom.tom.data.RealmRepo
import com.tomtom.tom.domain.Interactor
import com.tomtom.tom.domain.RetrieveUserReposUseCase
import com.tomtom.tom.domain.RetrieveUserReposUseCaseImpl
import com.tomtom.tom.domain.model.RepoDomainModel

class MainActivityPresenterImpl(mainActivity: MainActivity):MainActivityContract.Presenter, Interactor.Presentation {


    val tag = this.javaClass.simpleName
    val constantUser = "mralexgray"
    val view:MainActivityContract.View = mainActivity


    val retrieveReposUseCase:RetrieveUserReposUseCase = RetrieveUserReposUseCaseImpl()


    override fun onRepositoriesRetrieved(repos: List<RepoDomainModel>) {
        Log.d(tag, "Retrieved ${repos.size} repos")
        view.updateScreen(repos)
    }

    override fun onResume()   {
        Log.d(tag, "Activity triggered onResume()")
        val boundary = this

        Thread {
            val backendInteractor:Interactor.Backend = BackendRepo()
            val databaseInteractor: Interactor.DataBase = RealmRepo()
            retrieveReposUseCase.run(constantUser, backendInteractor, boundary, databaseInteractor)
        }.start()
    }

    override fun onCreate()   {  Log.d(tag, "Activity triggered onCreate()")    }
    override fun onPause()    {  Log.d(tag, "Activity triggered onPause()")     }
    override fun onDestroy()  {  Log.d(tag, "Activity triggered onDestroy()")   }
    override fun onStop()     {  Log.d(tag, "Activity triggered onStop()")      }

}