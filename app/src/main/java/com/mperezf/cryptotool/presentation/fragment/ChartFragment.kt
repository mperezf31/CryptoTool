package com.mperezf.cryptotool.presentation.fragment


import android.app.Fragment
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.mperezf.cryptotool.R
import com.mperezf.cryptotool.domain.model.Coin
import kotlinx.android.synthetic.main.fragment_chart.*


class ChartFragment : Fragment() {

    companion object {

        private val ARG_PARAM1 = "param1"

        fun newInstance(param1: Coin): ChartFragment {
            val fragment = ChartFragment()
            val args = Bundle()
            args.putParcelable(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }

    private var mCoinData: Coin? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mCoinData = arguments.getParcelable(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_chart, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity.title = mCoinData?.name
        loadChart()
    }

    private fun loadChart() {
        val dataset = BarDataSet(getDataSet(), "Values")
        dataset.color = Color.GRAY
        chart.data = BarData(dataset)
        chart.xAxis.valueFormatter = MyXAxisValueFormatter(getLabels())
        chart.xAxis.granularity = 1f;
        chart.xAxis.setDrawGridLines(false)
        chart.axisRight.isEnabled = false
        chart.axisRight.setDrawGridLines(false)
        chart.animateY(3000)
    }

    private fun getDataSet(): ArrayList<BarEntry>? {
        val data: ArrayList<BarEntry>? = ArrayList()
        data?.add(BarEntry(0f, getValueBar(mCoinData?.percentChange7d!!)))
        data?.add(BarEntry(1f, getValueBar(mCoinData?.percentChange24h!!)))
        data?.add(BarEntry(2f, getValueBar(mCoinData?.percentChangeIh!!)))
        data?.add(BarEntry(3f, mCoinData?.price_usd?.toFloat()!!))
        return data
    }

    private fun getLabels(): ArrayList<String>? {
        val labels: ArrayList<String>? = ArrayList()
        labels?.add("1 Month ago")
        labels?.add("1 Day ago")
        labels?.add("7 Hours ago")
        labels?.add("Now")
        return labels
    }

    private fun getValueBar(percent: String): Float {
        val valueChange=  mCoinData?.price_usd!!.toFloat() * percent.toFloat() / 100
        return mCoinData?.price_usd!!.toFloat() + valueChange
    }

    inner class MyXAxisValueFormatter(private val mValues: ArrayList<String>?) : IAxisValueFormatter {
        override fun getFormattedValue(value: Float, axis: AxisBase): String {
            // "value" represents the position of the label on the axis (x or y)
            return mValues!![value.toInt()]
        }
    }
}
