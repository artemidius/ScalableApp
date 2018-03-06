package com.tomtom.tom.data

import com.tomtom.tom.data.model.CommitRealmModel
import com.tomtom.tom.data.model.RepoRealmModel
import com.tomtom.tom.domain.Interactor
import com.tomtom.tom.domain.model.RepoDomainModel
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where

class RealmRepo:Interactor.DataBase {

    val realm = Realm.getDefaultInstance()

    override fun saveRepos(list: List<RepoDomainModel>?) {
        if (list != null) {
            for (repo in list) {
                saveRepository(repo)
            }
        }
    }

    override fun readAllRepos(): List<RepoDomainModel> = readAllRepos()

    override fun deleteAllRepos() = deleteAll()

    fun saveRepository(inputRepository: RepoDomainModel) {
        realm.executeTransaction {
            var repository = realm.createObject<RepoRealmModel>()
            var lastCommit = realm.createObject<CommitRealmModel>()

            lastCommit.author = inputRepository.lastCommit?.author
            lastCommit.message = inputRepository.lastCommit?.message
            lastCommit.date = inputRepository.lastCommit?.date

            repository.name = inputRepository.name
            repository.id = inputRepository.id
            repository.description = inputRepository.description
            repository.lastCommit = lastCommit
        }
    }

    fun getAllRepos(): List<RepoRealmModel>? {
        return realm.where<RepoRealmModel>().findAll()
    }

    fun deleteAll () {
        realm.executeTransaction{
            realm.deleteAll()
        }
    }
}