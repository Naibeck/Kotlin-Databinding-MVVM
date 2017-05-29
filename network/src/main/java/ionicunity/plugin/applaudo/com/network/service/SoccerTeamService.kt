package ionicunity.plugin.applaudo.com.network.service

import io.reactivex.Observable
import ionicunity.plugin.applaudo.com.network.api.SoccerTeamApi
import ionicunity.plugin.applaudo.com.network.model.SoccerTeam
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Alex Gomez on 5/29/2017.
 */
class SoccerTeamService {
    private val soccerTeamApi: SoccerTeamApi
    init {
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("http://applaudostudios.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        soccerTeamApi = retrofit.create(SoccerTeamApi::class.java)
    }

    fun getSoccerTeam(): Observable<List<SoccerTeam>> = soccerTeamApi.getSoccerTeam()
}