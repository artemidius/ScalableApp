package com.tomtom.tom.domain

interface RetrieveUserReposUseCase {
    fun run(name: String, dataInteractor: Interactor.Data, presentationInteractor: Interactor.Presentation)
}