package com.mperezf.cryptotool.presentation

import android.app.FragmentManager
import com.mperezf.cryptotool.R
import com.mperezf.cryptotool.presentation.fragment.CoinFragment

object Navigation {

    fun showCoinFragment(supportFragmentManager: FragmentManager?) {
        if (supportFragmentManager == null) return
        supportFragmentManager.beginTransaction()
                .replace(R.id.main_content, CoinFragment(), CoinFragment.FRAGMENT_TAG)
                .commit()
    }

}