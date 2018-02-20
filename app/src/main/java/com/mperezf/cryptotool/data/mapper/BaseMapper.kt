package com.mperezf.cryptotool.data.mapper

import io.reactivex.functions.Function
import java.util.*


abstract class BaseMapper<T, S> {

    protected abstract fun map(dataModel: T?): S

    fun getMapper(): Function<T, S> {
        return Function { T ->
            map(T)
        }
    }

    fun getListMapper(): Function<List<T>, List<S>> {
        return Function { list ->
            val resultList = list.mapTo(ArrayList<S>()) { map(it) }
            resultList
        }
    }
}

