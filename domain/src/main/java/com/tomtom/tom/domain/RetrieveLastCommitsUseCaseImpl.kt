package com.tomtom.tom.domain

import android.util.Log

class RetrieveLastCommitsUseCaseImpl : RetrieveLastCommitsUseCase {
    override fun run(name: String, backendInteractor: Interactor.Backend, presentationInteractor: Interactor.Presentation, databaseInteractor: Interactor.DataBase) {
        val localRepos = databaseInteractor.readAllRepos()
        for (repo in localRepos) {
            Log.d(this.javaClass.simpleName, "Last commit for ${repo.name}")
        }
    }
}