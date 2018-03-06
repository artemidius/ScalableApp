package com.tomtom.tom.data

import com.google.gson.Gson
import com.tomtom.tom.data.model.Mappper
import com.tomtom.tom.data.model.RepoDTO
import com.tomtom.tom.domain.Interactor
import com.tomtom.tom.domain.model.RepoDomainModel
import java.net.URL

class BackendRepo : Interactor.Backend {

    val tag = this.javaClass.simpleName

    override fun downloadRepos(name: String): List<RepoDomainModel>? {
        val json = URL(getReposUrl(name)).readText()
        val repositories: List<RepoDTO> = Gson().fromJson(json, Array<RepoDTO>::class.java).toList()
        return Mappper().listRepoDTOtoDomain(repositories)
    }

    private fun getReposUrl(userName: String): String = "https://api.github.com/users/$userName/repos"
}