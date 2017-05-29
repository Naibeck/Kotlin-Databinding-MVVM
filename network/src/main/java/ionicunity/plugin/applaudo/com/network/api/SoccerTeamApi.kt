package ionicunity.plugin.applaudo.com.network.api

import io.reactivex.Observable
import ionicunity.plugin.applaudo.com.network.model.SoccerTeam
import retrofit2.http.GET

/**
 * Created by Alex Gomez on 5/29/2017.
 */
interface SoccerTeamApi {
    @GET("/external/applaudo_homework.json")
    fun getSoccerTeam(): Observable<List<SoccerTeam>>
}