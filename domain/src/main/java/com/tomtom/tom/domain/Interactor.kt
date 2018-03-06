package com.tomtom.tom.domain

import com.tomtom.tom.domain.model.RepoDomainModel

interface Interactor {
    interface Presentation {
        fun onRepositoriesRetrieved(repos:List<RepoDomainModel>)
    }

    interface Data {
        fun retrieveRepos(name:String):List<RepoDomainModel>
    }

}