package com.tutorial.naibeck.applaudo

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.tutorial.naibeck.applaudo.adapter.SoccerTeamAdapter
import com.tutorial.naibeck.applaudo.databinding.ActivityMainBinding
import ionicunity.plugin.applaudo.com.network.SoccerTeamManager
import ionicunity.plugin.applaudo.com.network.model.SoccerTeam

class MainActivity : AppCompatActivity() {
    private val soccerTeamManager by lazy {
        SoccerTeamManager()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        soccerTeamManager.getSoccerTeams()
                .singleOrError()
                .subscribe({ startAdapter(mainBinding.soccerTeamList, it) },
                { Log.e("Network Error", "An error occurred retrieving teams data", it) })
    }

    fun printList(list: List<SoccerTeam>) {
        list.forEach {
            Log.d("Team", "Team info: $it")
        }
    }

    fun startAdapter(recyclerView: RecyclerView, list: List<SoccerTeam>) {
        recyclerView.adapter = SoccerTeamAdapter(list)
    }
}
