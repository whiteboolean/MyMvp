package com.example.mymvp.presenter

import com.example.mymvp.Goods
import com.example.mymvp.model.GoodsModelImpl
import com.example.mymvp.model.IGoodsModel
import com.example.mymvp.view.IGoodsView
import java.lang.ref.WeakReference

class GoodsPresenter<T : IGoodsView > : BasePresenter<T>(){

    //    var iGoodsView: IGoodsView? = view
    var iGoodModel: IGoodsModel? = GoodsModelImpl()



    //执行业务逻辑
    fun fetch() {
        if ((iBaseView?.get() != null) and (iGoodModel != null)) {
            iGoodModel?.showGoodsView(
                object : IGoodsModel.OnLoaderListener {
                    override fun onComplete(goods: MutableList<Goods>) {
                        iBaseView?.get()?.showGoodView(goods)
                    }

                    override fun onError(msg: String) {
                        iBaseView?.get()?.showErrorMessage("出错了")
                    }
                }
            )
        }
    }


}