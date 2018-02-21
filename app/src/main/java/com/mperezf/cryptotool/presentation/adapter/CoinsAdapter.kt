package com.mperezf.cryptotool.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mperezf.cryptotool.R
import com.mperezf.cryptotool.domain.model.Coin
import com.mperezf.cryptotool.presentation.view.CoinView
import kotlinx.android.synthetic.main.coin_row.view.*


class CoinsAdapter(private val mCoins: List<Coin>,
                   private val mCoinListener: CoinView.CoinSelectedListener) : RecyclerView.Adapter<CoinsAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.coin_row, parent, false)
        return Holder(itemView)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val copinData = mCoins[position]
        holder.bind(copinData, mCoinListener)
    }

    override fun getItemCount(): Int {
        return mCoins.size
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(coin: Coin, itemClick: CoinView.CoinSelectedListener) {
            itemView.tvCoinName.text = "hello"
            itemView.setOnClickListener { itemClick.onCoinSelected(coin) }
        }
    }
}