package com.example.mymvp.presenter

import com.example.mymvp.Goods
import com.example.mymvp.model.IGoodsModel
import com.example.mymvp.view.IBaseView
import java.lang.ref.WeakReference

open class BasePresenter<T : IBaseView> {
    //    var iGoodsView: IGoodsView? = view
    var iBaseView: WeakReference<T>? = null


    fun attach(view: T) {
        iBaseView = WeakReference(view)

    }

    fun detach() {
        iBaseView?.clear()
        iBaseView = null
    }


}