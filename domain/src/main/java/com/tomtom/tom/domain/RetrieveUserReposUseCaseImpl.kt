package com.tomtom.tom.domain

import android.util.Log

class RetrieveUserReposUseCaseImpl : RetrieveUserReposUseCase {
    override fun run(name: String, dataInteractor: Interactor.Data, presentationInteractor: Interactor.Presentation) {
        Log.i(this.javaClass.simpleName, "Use case running")
        val reposList = dataInteractor.retrieveRepos(name)
        Log.i(this.javaClass.simpleName, "Use case has ${reposList.size} repos to process")
        presentationInteractor.onRepositoriesRetrieved(reposList)
    }
}