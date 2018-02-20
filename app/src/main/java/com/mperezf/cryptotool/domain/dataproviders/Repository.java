package com.mperezf.cryptotool.domain.dataproviders;

import com.mperezf.cryptotool.domain.model.Coin;

import java.util.List;

import io.reactivex.Observable;

public interface Repository {

    Observable<List<Coin>> getCoins();

} 
