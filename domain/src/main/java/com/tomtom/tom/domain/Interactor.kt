package com.tomtom.tom.domain

import com.tomtom.tom.domain.model.CommitDomainModel
import com.tomtom.tom.domain.model.RepoDomainModel

interface Interactor {

    interface Presentation {
        fun onRepositoriesRetrieved(repos:List<RepoDomainModel>)
        fun onLastCommitsRetrieved(repos:List<RepoDomainModel>)
    }

    interface Backend {
        fun downloadRepos(name:String):List<RepoDomainModel>?
        fun getLastCommit(userName:String, repoName:String):CommitDomainModel?
    }

    interface DataBase {
        fun saveRepos(list:List<RepoDomainModel>?)
        fun readAllRepos():List<RepoDomainModel>
        fun deleteAllRepos()
        fun closeRealm()
    }

}