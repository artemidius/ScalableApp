package com.tomtom.tom.domain.model

data class RepoDomainModel (
        var id:String?,
        var name:String?,
        var description:String?,
        var lastCommit:CommitDomainModel?
)