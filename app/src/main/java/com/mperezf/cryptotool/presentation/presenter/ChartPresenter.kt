package com.mperezf.cryptotool.presentation.presenter

import com.github.mikephil.charting.data.BarEntry
import com.mperezf.cryptotool.domain.model.Coin
import com.mperezf.cryptotool.presentation.view.ChartView

class ChartPresenter : BasePresenter<ChartView>() {

    fun getCharData(coinData: Coin?) {
        if (isAttached) {
            view?.onDataSet(getLabels(coinData), getDataSet(coinData))
        }
    }

    private fun getDataSet(coinData: Coin?): ArrayList<BarEntry>? {
        val data: ArrayList<BarEntry>? = ArrayList()
        data?.add(BarEntry(0f, getValueBar(coinData, coinData?.percentChange7d!!)))
        data?.add(BarEntry(1f, getValueBar(coinData, coinData?.percentChange24h!!)))
        data?.add(BarEntry(2f, getValueBar(coinData, coinData?.percentChangeIh!!)))
        data?.add(BarEntry(3f, coinData?.price_usd?.toFloat()!!))
        return data
    }

    private fun getLabels(coinData: Coin?): ArrayList<String>? {
        val labels: ArrayList<String>? = ArrayList()
        labels?.add("1 Month ago")
        labels?.add("1 Day ago")
        labels?.add("7 Hours ago")
        labels?.add("Now")
        return labels
    }

    private fun getValueBar(coinData: Coin?, percent: String): Float {
        val valueChange = coinData?.price_usd!!.toFloat() * percent.toFloat() / 100
        return coinData?.price_usd.toFloat() + valueChange
    }

}