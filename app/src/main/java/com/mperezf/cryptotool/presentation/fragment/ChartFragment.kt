package com.mperezf.cryptotool.presentation.fragment


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
import com.mperezf.cryptotool.presentation.presenter.ChartPresenter
import com.mperezf.cryptotool.presentation.view.ChartView
import kotlinx.android.synthetic.main.fragment_chart.*
import javax.inject.Inject


class ChartFragment : BaseFragment(), ChartView {

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

    @Inject lateinit var mChartPresenter: ChartPresenter
    private var mCoinData: Coin? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component()?.inject(this)
        if (arguments != null) {
            mCoinData = arguments.getParcelable(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_chart, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mChartPresenter.attach(this)
        activity.title = mCoinData?.name
        mChartPresenter.getCharData(coinData = mCoinData)
    }

    override fun onDataSet(labels: ArrayList<String>?, dataSet: ArrayList<BarEntry>?) {
        val dataset = BarDataSet(dataSet, "Values")
        dataset.color = Color.GRAY
        chart.data = BarData(dataset)
        chart.xAxis.valueFormatter = MyXAxisValueFormatter(labels)
        chart.xAxis.granularity = 1f;
        chart.xAxis.setDrawGridLines(false)
        chart.axisRight.isEnabled = false
        chart.axisRight.setDrawGridLines(false)
        chart.animateY(3000)
    }

    inner class MyXAxisValueFormatter(private val mValues: ArrayList<String>?) : IAxisValueFormatter {
        override fun getFormattedValue(value: Float, axis: AxisBase): String {
            // "value" represents the position of the label on the axis (x or y)
            return mValues!![value.toInt()]
        }
    }

}
