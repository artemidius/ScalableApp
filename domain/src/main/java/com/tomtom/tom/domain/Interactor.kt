package com.tomtom.tom.domain

import com.tomtom.tom.domain.model.RepoDomainModel

interface Interactor {

    interface Presentation {
        fun onRepositoriesRetrieved(repos:List<RepoDomainModel>)
    }

    interface Backend {
        fun downloadRepos(name:String):List<RepoDomainModel>?
    }

    interface DataBase {
        fun saveRepos(list:List<RepoDomainModel>?)
        fun readAllRepos():List<RepoDomainModel>
        fun deleteAllRepos()
        fun closeRealm()
    }

}