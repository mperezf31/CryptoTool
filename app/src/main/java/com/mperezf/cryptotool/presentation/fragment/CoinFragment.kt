package com.mperezf.cryptotool.presentation.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mperezf.cryptotool.R

class CoinFragment : Fragment() {

    companion object {
        val FRAGMENT_TAG = "coin_fragment"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_coin, container, false)
    }


}
