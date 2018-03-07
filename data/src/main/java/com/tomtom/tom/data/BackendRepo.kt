package com.tomtom.tom.data

import android.util.Log
import com.google.gson.Gson
import com.tomtom.tom.data.model.CommitDTO
import com.tomtom.tom.data.model.Mappper
import com.tomtom.tom.data.model.RepoDTO
import com.tomtom.tom.domain.Interactor
import com.tomtom.tom.domain.model.CommitDomainModel
import com.tomtom.tom.domain.model.RepoDomainModel
import java.io.FileNotFoundException
import java.net.URL

class BackendRepo : Interactor.Backend {
    override fun getLastCommit(userName: String, repoName: String): CommitDomainModel? {
        try {
            val json = URL(getCommitsUrl(userName, repoName)).readText()
            val commits: List<CommitDTO> = Gson().fromJson(json, Array<CommitDTO>::class.java).toList()
            if (commits.size > 0) return Mappper().commitDTOtoDomain(commits[0])
            else return null
        } catch (e: Throwable) {
            return null
        }
    }

    val tag = this.javaClass.simpleName

    override fun downloadRepos(name: String): List<RepoDomainModel>? {
        try {
            val json = URL(getReposUrl(name)).readText()
            val repositories: List<RepoDTO> = Gson().fromJson(json, Array<RepoDTO>::class.java).toList()
            return Mappper().listRepoDTOtoDomain(repositories)
        } catch (e: Throwable) {
            return null
        }
    }

    private val token = "ae072b973d74f30203abb4bb0c46b81ddc45b92c"

    private fun getReposUrl(userName: String): String = "https://api.github.com/users/$userName/repos?access_token=$token"
    private fun getCommitsUrl(userName: String, repoName: String): String = "https://api.github.com/repos/$userName/$repoName/commits?access_token=$token"
}