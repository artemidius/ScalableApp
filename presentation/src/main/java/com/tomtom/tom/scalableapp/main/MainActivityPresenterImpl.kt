package com.tomtom.tom.scalableapp.main

import android.util.Log
import com.tomtom.tom.data.BackendRepo
import com.tomtom.tom.data.RealmRepo
import com.tomtom.tom.domain.*
import com.tomtom.tom.domain.model.RepoDomainModel

class MainActivityPresenterImpl(mainActivity: MainActivity):MainActivityContract.Presenter, Interactor.Presentation {

    val tag = this.javaClass.simpleName
//    val constantUser = "artemidius"
    val constantUser = "mralexgray"
    val view:MainActivityContract.View = mainActivity

    val retrieveReposUseCase:RetrieveUserReposUseCase = RetrieveUserReposUseCaseImpl()
    val retrieveLastCommits:RetrieveLastCommitsUseCase = RetrieveLastCommitsUseCaseImpl()

    override fun onRepositoriesRetrieved(repos: List<RepoDomainModel>) {
        Log.d(tag, "Retrieved ${repos.size} repos")
        view.updateScreen(repos)

        val boundary = this
        Thread {
            val backendInteractor:Interactor.Backend = BackendRepo()
            val databaseInteractor: Interactor.DataBase = RealmRepo()
            retrieveLastCommits.run(constantUser, backendInteractor, boundary, databaseInteractor)
        }.start()
    }

    override fun onLastCommitsRetrieved(repos: List<RepoDomainModel>) {
        Log.d(tag, "Retrieved ${repos.size} repos with commits")
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

    override fun onCreate()   {
        Log.d(tag, "Activity triggered onCreate()")
        view.updateTitle("User - $constantUser")

    }
    override fun onPause()    {  Log.d(tag, "Activity triggered onPause()")     }
    override fun onDestroy()  {  Log.d(tag, "Activity triggered onDestroy()")   }
    override fun onStop()     {  Log.d(tag, "Activity triggered onStop()")      }

}