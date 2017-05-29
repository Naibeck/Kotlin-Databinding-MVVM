package ionicunity.plugin.applaudo.com.network.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by Alex Gomez on 5/29/2017.
 */
data class SoccerTeam (@SerializedName("id") val id: Int,
                       @SerializedName("team_name") val name: String,
                       @SerializedName("since") val since: Int,
                       @SerializedName("coach") val coach: String,
                       @SerializedName("team_nickname") val nickname: String,
                       @SerializedName("stadium") val stadium: String,
                       @SerializedName("img_logo") val logoUrl: String,
                       @SerializedName("img_stadium") val stadiumUrl: String,
                       @SerializedName("latitude") val latitude: Double,
                       @SerializedName("longitude") val longitude: Double,
                       @SerializedName("website") val website: String,
                       @SerializedName("tickets_url") val ticketsUrl: String,
                       @SerializedName("address") val address: String,
                       @SerializedName("phone_number") val phone: String,
                       @SerializedName("description") val description: String,
                       @SerializedName("video_url") val videoUrl: String,
                       @SerializedName("schedule_games") val scheduleGames: List<ScheduleGame>) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<SoccerTeam> = object : Parcelable.Creator<SoccerTeam> {
            override fun createFromParcel(source: Parcel): SoccerTeam = SoccerTeam(source)
            override fun newArray(size: Int): Array<SoccerTeam?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
    source.readInt(),
    source.readString(),
    source.readInt(),
    source.readString(),
    source.readString(),
    source.readString(),
    source.readString(),
    source.readString(),
    source.readDouble(),
    source.readDouble(),
    source.readString(),
    source.readString(),
    source.readString(),
    source.readString(),
    source.readString(),
    source.readString(),
    source.createTypedArrayList(ScheduleGame.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(name)
        dest.writeInt(since)
        dest.writeString(coach)
        dest.writeString(nickname)
        dest.writeString(stadium)
        dest.writeString(logoUrl)
        dest.writeString(stadiumUrl)
        dest.writeDouble(latitude)
        dest.writeDouble(longitude)
        dest.writeString(website)
        dest.writeString(ticketsUrl)
        dest.writeString(address)
        dest.writeString(phone)
        dest.writeString(description)
        dest.writeString(videoUrl)
        dest.writeTypedList(scheduleGames)
    }
}