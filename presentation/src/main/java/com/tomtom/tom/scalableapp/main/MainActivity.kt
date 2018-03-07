package com.tomtom.tom.scalableapp.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.tomtom.tom.domain.model.RepoDomainModel
import com.tomtom.tom.scalableapp.R
import com.tomtom.tom.scalableapp.adapters.ReposAdapter
import com.tomtom.tom.scalableapp.base.BaseActivity

class MainActivity : BaseActivity(), MainActivityContract.View {

    val tag = this.javaClass.simpleName
    lateinit var recyclerView: RecyclerView
    lateinit var adapter:ReposAdapter


    lateinit var presenter:MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
        presenter = MainActivityPresenterImpl(this)
        presenter.onCreate()

    }

    private fun initRecycler() {
        recyclerView = findViewById(R.id.recycler_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ReposAdapter(emptyList(), this)
        recyclerView.adapter = adapter
    }

    override fun updateScreen(list: List<RepoDomainModel>) {
        runOnUiThread({
            Log.d(tag, "Presenter triggered updateScreen with ${list.size} repos")
            adapter.updateList(list)
        })
    }

    override fun updateTitle(t: String) {
        title = t
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

}
