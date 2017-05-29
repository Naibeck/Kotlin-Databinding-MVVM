package ionicunity.plugin.applaudo.com.network.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by Alex Gomez on 5/29/2017.
 */
data class ScheduleGame (@SerializedName("date") val data: String,
                         @SerializedName("stadium") val stadium: String) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<ScheduleGame> = object : Parcelable.Creator<ScheduleGame> {
            override fun createFromParcel(source: Parcel): ScheduleGame = ScheduleGame(source)
            override fun newArray(size: Int): Array<ScheduleGame?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
    source.readString(),
    source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(data)
        dest.writeString(stadium)
    }
}