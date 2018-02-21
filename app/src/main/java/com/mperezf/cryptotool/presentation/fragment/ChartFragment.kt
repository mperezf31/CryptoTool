package com.mperezf.cryptotool.presentation.fragment


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mperezf.cryptotool.R
import com.mperezf.cryptotool.domain.model.Coin


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
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_chart, container, false)
    }

}
