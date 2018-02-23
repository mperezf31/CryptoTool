package com.mperezf.cryptotool.presentation.view

import com.github.mikephil.charting.data.BarEntry

interface ChartView : BaseView {

    fun onDataSet(labels: ArrayList<String>?, dataSet: ArrayList<BarEntry>?)

}