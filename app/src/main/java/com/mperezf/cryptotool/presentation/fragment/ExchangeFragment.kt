package com.mperezf.cryptotool.presentation.fragment

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.view.*
import com.mperezf.cryptotool.R
import com.mperezf.cryptotool.domain.model.Exchange
import com.mperezf.cryptotool.presentation.adapter.ExchangeAdapter
import com.mperezf.cryptotool.presentation.presenter.ExchangePresenter
import com.mperezf.cryptotool.presentation.view.ExchangeView
import kotlinx.android.synthetic.main.fragment_exchange.*
import javax.inject.Inject

class ExchangeFragment : BaseFragment(), ExchangeView, ExchangeView.ExchangeSelectedListener {

    companion object {
        val FRAGMENT_TAG = "exchange_fragment"
    }

    @Inject lateinit var mExchangePresenter: ExchangePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component()?.inject(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        rvExchanges.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        mExchangePresenter.attach(this)
        mExchangePresenter.getExchanges()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_exchange, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                mExchangePresenter.getExchanges()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mExchangePresenter.detach()
    }

    override fun showExchange(exchanges: List<Exchange>) {
        rvExchanges.adapter = ExchangeAdapter(exchanges, this)
    }

    override fun onExchangeSelected(exchange: Exchange) {

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