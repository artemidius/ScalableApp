package com.tomtom.tom.data

import com.tomtom.tom.data.model.CommitRealmModel
import com.tomtom.tom.data.model.RepoRealmModel
import com.tomtom.tom.domain.model.RepoDomainModel
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where

class RealmRepo {
    val realm = Realm.getDefaultInstance()

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

    fun deleteAllRepos () {
        realm.executeTransaction{
            realm.deleteAll()
        }
    }
}