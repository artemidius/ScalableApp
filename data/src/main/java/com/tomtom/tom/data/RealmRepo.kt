package com.tomtom.tom.data

import android.util.Log
import com.tomtom.tom.data.model.CommitRealmModel
import com.tomtom.tom.data.model.Mappper
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

    override fun readAllRepos(): List<RepoDomainModel> = getAll()

    override fun deleteAllRepos() = deleteAll()

    fun saveRepository(inputRepository: RepoDomainModel) {
        Log.d(this.javaClass.simpleName, "Tread on write: ${Thread.currentThread().id}")
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

    fun getAll(): List<RepoDomainModel> {
        Log.d(this.javaClass.simpleName, "Tread on read: ${Thread.currentThread().id}")
        val snapShot = realm.where<RepoRealmModel>().findAll()
        return Mappper().snapshotToDomainList(snapShot)
    }

    fun deleteAll () {
        realm.executeTransaction{
            realm.deleteAll()
        }
    }

    override fun closeRealm() {
        realm.close()
    }
}