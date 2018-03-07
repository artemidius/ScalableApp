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
import android.support.v7.util.DiffUtil


class ReposAdapter(var repos: List<RepoDomainModel>, val context: Context) : RecyclerView.Adapter<ReposAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        val repo = repos[position]
        val lastCommit: CommitDomainModel? = repo.lastCommit

        if (holder != null) {
            holder.textView.repo_name.text = repo.name
            if (lastCommit != null) {
                holder.textView.by.visibility = View.VISIBLE
                holder.textView.author.visibility = View.VISIBLE
                holder.textView.author.text = lastCommit.author
                holder.textView.on.visibility = View.VISIBLE
                holder.textView.date.visibility = View.VISIBLE
                holder.textView.spinner.visibility = View.GONE
                val date = lastCommit.date?:""
                holder.textView.date.text = date.substring(0..9)

            }
        }

    }

    override fun getItemCount(): Int = repos.size

    class ViewHolder(val textView: View) : RecyclerView.ViewHolder(textView)

    fun updateList(newList: List<RepoDomainModel>) {
        repos = newList
        notifyDataSetChanged()
    }
}