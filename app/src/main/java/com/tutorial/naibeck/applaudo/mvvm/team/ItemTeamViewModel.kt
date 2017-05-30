package com.tutorial.naibeck.applaudo.mvvm.team

import android.content.Intent
import android.databinding.ObservableField
import android.view.View
import com.tutorial.naibeck.applaudo.TeamDetailActivity
import ionicunity.plugin.applaudo.com.network.model.SoccerTeam

/**
 * Created by Alex Gomez on 5/29/2017.
 */
class ItemTeamViewModel(val soccerTeam: SoccerTeam) {
    val logoUrl = ObservableField<String>()
    val name = ObservableField<String>()

    init {
        logoUrl.set(soccerTeam.logoUrl)
        name.set(soccerTeam.name)
    }

    fun onTeamClicked(view: View) = with(view) {
        val intent = Intent(context, TeamDetailActivity::class.java)
        intent.putExtra("", soccerTeam)
        context.startActivity(intent)
    }

    interface OnTeamClick {
        fun launchDetail(soccerTeam: SoccerTeam)
    }
}