package com.mperezf.cryptotool.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mperezf.cryptotool.R
import com.mperezf.cryptotool.domain.model.Coin
import com.mperezf.cryptotool.presentation.presenter.CoinPresenter
import com.mperezf.cryptotool.presentation.view.CoinView
import javax.inject.Inject

class CoinFragment : BaseFragment(), CoinView {

    companion object {
        val FRAGMENT_TAG = "coin_fragment"
    }

    @Inject public lateinit var coinPresenter: CoinPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component()?.inject(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coinPresenter.attach(this)
        coinPresenter.getCoins()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_coin, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        coinPresenter.detach()
    }

    override fun showCoins(coins: List<Coin>) {
        Log.e("", "------------>")
    }

    override fun onError(message: String?) {
    }

    override fun onHideLoading() {
    
    }

    override fun onShowLoading() {
       
    }
}
