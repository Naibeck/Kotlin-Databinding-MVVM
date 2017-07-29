package com.tutorial.naibeck.applaudo

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.tutorial.naibeck.applaudo.adapter.SoccerTeamAdapter
import com.tutorial.naibeck.applaudo.databinding.ActivityMainBinding
import com.tutorial.naibeck.applaudo.mvvm.team.ItemTeamViewModel
import ionicunity.plugin.applaudo.com.network.SoccerTeamManager
import ionicunity.plugin.applaudo.com.network.model.SoccerTeam

import android.util.Log;

class MainActivity : AppCompatActivity(), ItemTeamViewModel.OnTeamClick {
    private val soccerTeamManager by lazy {
        SoccerTeamManager()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.testing)
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
        recyclerView.adapter = SoccerTeamAdapter(list, this)
    }

    override fun launchDetail(soccerTeam: SoccerTeam) {
        val intent = Intent(this, TeamDetailActivity::class.java)
        intent.putExtra(TeamDetailActivity.TEAM, soccerTeam)
        startActivity(intent)
    }
}
