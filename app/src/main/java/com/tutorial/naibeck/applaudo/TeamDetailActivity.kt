package com.tutorial.naibeck.applaudo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class TeamDetailActivity : AppCompatActivity() {
    companion object {
        val TEAM = "teamDetail"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)
    }
}
