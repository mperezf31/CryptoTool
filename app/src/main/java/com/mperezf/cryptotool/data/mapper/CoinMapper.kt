package com.mperezf.cryptotool.data.mapper

import android.graphics.Color
import com.mperezf.cryptotool.data.model.CoinData
import com.mperezf.cryptotool.domain.model.Coin

class CoinMapper : BaseMapper<CoinData, Coin>() {

    public override fun map(dataModel: CoinData?): Coin {
        return Coin(dataModel?.id, getImage(dataModel?.id?.replace("-", "_")), getColor(dataModel?.percent_change_1h), dataModel?.name, dataModel?.symbol, dataModel?.rank, dataModel?.price_usd, dataModel?.price_btc,
                dataModel?.percent_change_1h, dataModel?.percent_change_24h, dataModel?.percent_change_7d, dataModel?.last_updated)

    }

    private fun getImage(id: String?): String {
        return "https://iqoption.com/lp/ultimate-trading/assets/images/$id.png"
        //return "https://www.criptomonedas.co/static/img/$id.png"
    }


    private fun getColor(percent_change_1h: String?): Int {
        if (java.lang.Double.parseDouble(percent_change_1h) > 0) {
            return Color.parseColor("#228B22")
        } else
            return Color.parseColor("#7f0000")
    }
}

