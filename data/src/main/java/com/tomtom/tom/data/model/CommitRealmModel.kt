package com.tomtom.tom.data.model

import io.realm.RealmObject

open class CommitRealmModel : RealmObject() {
    var message:String? = null
    var author:String? = null
    var date:String? = null
}