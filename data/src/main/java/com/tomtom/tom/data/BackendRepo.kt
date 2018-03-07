package com.tomtom.tom.data

import android.util.Log
import com.google.gson.Gson
import com.tomtom.tom.data.model.CommitDTO
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

    fun downloadLastCommit(userName: String, repoName: String) {
        val json = URL(getCommitsUrl(userName, repoName)).readText()
        val commits: List<CommitDTO> = Gson().fromJson(json, Array<CommitDTO>::class.java).toList()
        Log.d(tag, "Got ${commits.size} commits")
    }

    private fun getReposUrl(userName: String): String = "https://api.github.com/users/$userName/repos"
    private fun getCommitsUrl(userName: String, repoName: String): String = "https://api.github.com/repos/$userName/$repoName/commits"
}