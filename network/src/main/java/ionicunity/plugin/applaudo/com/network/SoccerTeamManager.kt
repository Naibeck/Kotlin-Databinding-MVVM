package ionicunity.plugin.applaudo.com.network

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ionicunity.plugin.applaudo.com.network.model.SoccerTeam
import ionicunity.plugin.applaudo.com.network.service.SoccerTeamService

/**
 * Created by Alex Gomez on 5/29/2017.
 */
class SoccerTeamManager {
    private val soccerTeamService = SoccerTeamService()

    fun getSoccerTeams(): Observable<List<SoccerTeam>> {
        return soccerTeamService.getSoccerTeam().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}