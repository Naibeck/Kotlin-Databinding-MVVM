package com.tutorial.naibeck.applaudo.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tutorial.naibeck.applaudo.R
import com.tutorial.naibeck.applaudo.databinding.TeamSoccerItemBinding
import com.tutorial.naibeck.applaudo.mvvm.team.ItemTeamViewModel
import ionicunity.plugin.applaudo.com.network.model.SoccerTeam

/**
 * Created by Alex Gomez on 5/29/2017.
 */
class SoccerTeamAdapter(val teamList: List<SoccerTeam>) : RecyclerView.Adapter<SoccerTeamAdapter.ViewHolder>() {
    override fun getItemCount(): Int = teamList.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.teamItemBinding?.viewModel = ItemTeamViewModel(teamList[position])
        holder?.teamItemBinding?.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.team_soccer_item, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val teamItemBinding: TeamSoccerItemBinding = DataBindingUtil.bind(itemView)
    }
}