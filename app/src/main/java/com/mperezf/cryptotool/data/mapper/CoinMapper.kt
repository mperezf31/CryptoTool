package com.mperezf.cryptotool.data.mapper

import com.mperezf.cryptotool.data.model.CoinData
import com.mperezf.cryptotool.domain.model.Coin

class CoinMapper : BaseMapper<CoinData, Coin>() {

    public override fun map(dataModel: CoinData?): Coin {
        return Coin(dataModel?.id, getImage(dataModel?.id?.replace("-", "_")), dataModel?.name, dataModel?.symbol, dataModel?.rank, dataModel?.price_usd, dataModel?.price_btc,
                dataModel?.percent_change_1h, dataModel?.percent_change_24h, dataModel?.percent_change_7d, dataModel?.last_updated)

    }


    private fun getImage(id: String?): String {
        return "https://iqoption.com/lp/ultimate-trading/assets/images/$id.png"
        //return "https://www.criptomonedas.co/static/img/$id.png"
    }
}

