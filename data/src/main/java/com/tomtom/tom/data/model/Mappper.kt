package com.tomtom.tom.data.model

import com.tomtom.tom.domain.model.RepoDomainModel

class Mappper {

    fun repoDataToDomain(input:RepoDTO):RepoDomainModel = RepoDomainModel(
            id = input.id,
            name = input.name,
            description = input.description,
            lastCommit = null
    )

    fun realmToDomain(input:RepoRealmModel):RepoDomainModel = RepoDomainModel(
            id = input.id,
            name = input.name,
            description = input.description,
            lastCommit = null
    )



    fun snapshotToDomainList(inputList:List<RepoRealmModel>):List<RepoDomainModel> {
        val outputList = mutableListOf<RepoDomainModel>()
        for (repo in inputList) {
            outputList.add(realmToDomain(repo))
        }
        return outputList
    }

    fun listRepoDTOtoDomain(inputList:List<RepoDTO>):List<RepoDomainModel> {
        val outputList = mutableListOf<RepoDomainModel>()
        for (repo in inputList) {
            outputList.add(repoDataToDomain(repo))
        }
        return outputList
    }
}