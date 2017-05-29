package com.tutorial.naibeck.applaudo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import ionicunity.plugin.applaudo.com.network.SoccerTeamManager
import ionicunity.plugin.applaudo.com.network.model.SoccerTeam

class MainActivity : AppCompatActivity() {
    private val soccerTeamManager by lazy {
        SoccerTeamManager()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        soccerTeamManager.getSoccerTeams()
                .singleOrError()
                .subscribe({ printList(it) },
                { Log.e("Network Error", "An error occurred retrieving teams data", it) })
    }

    fun printList(list: List<SoccerTeam>) {
        list.forEach {
            Log.d("Team", "Team info: $it")
        }
    }
}
