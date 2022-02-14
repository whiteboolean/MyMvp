package com.example.mymvp.model

import com.example.mymvp.Goods

interface IGoodsModel {

    fun showGoodsView(onLoaderListener: OnLoaderListener)

    interface OnLoaderListener {
        fun onComplete(goods: MutableList<Goods>)
        fun onError(msg: String)
    }

}