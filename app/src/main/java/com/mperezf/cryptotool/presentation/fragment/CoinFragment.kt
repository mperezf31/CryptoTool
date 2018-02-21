package com.mperezf.cryptotool.presentation.fragment

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mperezf.cryptotool.R
import com.mperezf.cryptotool.domain.model.Coin
import com.mperezf.cryptotool.presentation.adapter.CoinsAdapter
import com.mperezf.cryptotool.presentation.presenter.CoinPresenter
import com.mperezf.cryptotool.presentation.view.CoinView
import kotlinx.android.synthetic.main.fragment_coin.*
import javax.inject.Inject

class CoinFragment : BaseFragment(), CoinView, CoinView.CoinSelectedListener {

    companion object {
        val FRAGMENT_TAG = "coin_fragment"
    }

    @Inject lateinit var mCoinPresenter: CoinPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component()?.inject(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCoins.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        mCoinPresenter.attach(this)
        mCoinPresenter.getCoins()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_coin, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        mCoinPresenter.detach()
    }

    override fun showCoins(coins: List<Coin>) {
        rvCoins.adapter = CoinsAdapter(coins, this)
    }

    override fun onCoinSelected(coin: Coin) {

    }

    override fun onError(message: String?) {
    }

    override fun onHideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun onShowLoading() {
        progressBar.visibility = View.VISIBLE
    }
}
