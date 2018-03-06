package com.tomtom.tom.data.model

import io.realm.RealmObject

open class RepoRealmModel:RealmObject() {
    var id: String? = null
    var name: String? = null
    var description: String? = null
    var lastCommit: CommitRealmModel? = null
}