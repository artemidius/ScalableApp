package com.tomtom.tom.domain

class RetrieveUserReposUseCaseImpl : RetrieveUserReposUseCase {
    override fun run(name: String, backendInteractor: Interactor.Backend, presentationInteractor: Interactor.Presentation, databaseInteractor: Interactor.DataBase) {
        val localRepos = databaseInteractor.readAllRepos()
        presentationInteractor.onRepositoriesRetrieved(localRepos)
        val reposFromInternet = backendInteractor.downloadRepos(name)
        if (reposFromInternet != null) {
            databaseInteractor.deleteAllRepos()
            databaseInteractor.saveRepos(reposFromInternet)
            presentationInteractor.onRepositoriesRetrieved(databaseInteractor.readAllRepos())
        }
    }
}