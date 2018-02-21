package com.mperezf.cryptotool.presentation.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mperezf.cryptotool.R
import com.mperezf.cryptotool.domain.model.Exchange
import com.mperezf.cryptotool.presentation.view.ExchangeView
import kotlinx.android.synthetic.main.exchange_row.view.*

class ExchangeAdapter(private val mExchanges: List<Exchange>,
                      private val mExchangeListener: ExchangeView.ExchangeSelectedListener) : RecyclerView.Adapter<ExchangeAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.exchange_row, parent, false)
        return Holder(itemView)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val exchangeData = mExchanges[position]
        holder.bind(exchangeData, mExchangeListener)
    }

    override fun getItemCount(): Int {
        return mExchanges.size
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun bind(exchange: Exchange, itemClick: ExchangeView.ExchangeSelectedListener) {
            itemView.tvExchangeName.text = exchange.name
            itemView.setOnClickListener { itemClick.onExchangeSelected(exchange) }
        }
    }
}