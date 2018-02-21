package com.mperezf.cryptotool.data.mapper

import com.mperezf.cryptotool.data.model.ExchangeData
import com.mperezf.cryptotool.domain.model.Exchange

class ExchangeMapper : BaseMapper<ExchangeData, Exchange>() {

    public override fun map(dataModel: ExchangeData?): Exchange {
        return Exchange(dataModel?.name, dataModel?.route)
    }
}