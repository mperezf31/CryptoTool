package com.mperezf.cryptotool.domain.dataproviders;

import com.mperezf.cryptotool.domain.model.Coin;
import com.mperezf.cryptotool.domain.model.Exchange;

import java.util.List;

import io.reactivex.Observable;

public interface Repository {

    Observable<List<Coin>> getCoins();

    Observable<List<Exchange>> getExchanges();
} 
