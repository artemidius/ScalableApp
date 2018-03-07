package com.tomtom.tom.domain

import android.util.Log

class RetrieveLastCommitsUseCaseImpl : RetrieveLastCommitsUseCase {
    override fun run(name: String, backendInteractor: Interactor.Backend, presentationInteractor: Interactor.Presentation, databaseInteractor: Interactor.DataBase) {
        var localRepos = databaseInteractor.readAllRepos()
        for (repo in localRepos) {
            Log.d(this.javaClass.simpleName, "Last commit for ${repo.name}")
            if (repo.name != null) {
                val lastCommit = backendInteractor.getLastCommit(name, repo.name!!)
                repo.lastCommit = lastCommit
            }
        }
        presentationInteractor.onLastCommitsRetrieved(localRepos)
    }
}