package com.tomtom.tom.domain.model

data class RepoDomainModel (
        val id:String?,
        val name:String?,
        val description:String?,
        val lastCommit:CommitDomainModel?
)