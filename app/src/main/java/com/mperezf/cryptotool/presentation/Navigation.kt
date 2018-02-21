package com.mperezf.cryptotool.presentation

import android.app.FragmentManager
import com.mperezf.cryptotool.R
import com.mperezf.cryptotool.presentation.fragment.CoinFragment
import com.mperezf.cryptotool.presentation.fragment.ExchangeFragment

object Navigation {

    fun showCoinFragment(supportFragmentManager: FragmentManager?) {
        if (supportFragmentManager == null) return
        supportFragmentManager.beginTransaction()
                .replace(R.id.main_content, CoinFragment(), CoinFragment.FRAGMENT_TAG)
                .commit()
    }

    fun showExchangeFragment(fragmentManager: FragmentManager?) {
        if (fragmentManager == null) return
        fragmentManager.beginTransaction()
                .replace(R.id.main_content, ExchangeFragment(), ExchangeFragment.FRAGMENT_TAG)
                .commit()
    }

}