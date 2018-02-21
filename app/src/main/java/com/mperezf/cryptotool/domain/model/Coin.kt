package com.mperezf.cryptotool.domain.model

import android.os.Parcel
import android.os.Parcelable

class Coin(val id: String?, val image: String?, val color: Int?, val name: String?, val symbol: String?, val rank: String?, val price_usd: String?, val priceBtc: String?, val
percentChangeIh: String?, val percentChange24h: String?, val percentChange7d: String?, val lastUpdated: String?) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeString(image)
        writeValue(color)
        writeString(name)
        writeString(symbol)
        writeString(rank)
        writeString(price_usd)
        writeString(priceBtc)
        writeString(percentChangeIh)
        writeString(percentChange24h)
        writeString(percentChange7d)
        writeString(lastUpdated)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Coin> = object : Parcelable.Creator<Coin> {
            override fun createFromParcel(source: Parcel): Coin = Coin(source)
            override fun newArray(size: Int): Array<Coin?> = arrayOfNulls(size)
        }
    }
}

