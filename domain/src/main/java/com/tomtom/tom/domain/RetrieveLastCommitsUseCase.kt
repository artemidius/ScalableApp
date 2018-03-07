package com.tomtom.tom.domain

interface RetrieveLastCommitsUseCase {
    fun run(name: String,
            backendInteractor: Interactor.Backend,
            presentationInteractor: Interactor.Presentation,
            databaseInteractor: Interactor.DataBase)
}
