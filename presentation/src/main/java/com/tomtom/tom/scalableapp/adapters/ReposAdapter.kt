package com.tomtom.tom.scalableapp.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tomtom.tom.domain.model.CommitDomainModel
import com.tomtom.tom.domain.model.RepoDomainModel
import com.tomtom.tom.scalableapp.R
import kotlinx.android.synthetic.main.item_repo.view.*


class ReposAdapter(val repos: List<RepoDomainModel>, val context: Context) : RecyclerView.Adapter<ReposAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        val repo = repos[position]
        val lastCommit: CommitDomainModel? = repo.lastCommit

        if (holder != null) {
            holder.textView.repo_name.text = repo.name
            if (lastCommit != null) holder.textView.last_comit.text = lastCommit.date
        }

    }

    override fun getItemCount(): Int = repos.size

    class ViewHolder(val textView: View) : RecyclerView.ViewHolder(textView)
}