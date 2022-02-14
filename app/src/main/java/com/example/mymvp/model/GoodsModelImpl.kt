package com.example.mymvp.model

import com.example.mymvp.Goods
import com.example.mymvp.R

class GoodsModelImpl : IGoodsModel {

    private fun getData():MutableList<Goods> {
        val list = mutableListOf<Goods>()
        val goods1 = Goods(R.mipmap.ic_launcher, "1", "111")
        val goods2 = Goods(R.mipmap.ic_launcher, "2", "222")
        val goods3 = Goods(R.mipmap.ic_launcher, "3", "333")
        val goods4 = Goods(R.mipmap.ic_launcher, "4", "444")
        val goods5 = Goods(R.mipmap.ic_launcher, "5", "555")
        val goods6 = Goods(R.mipmap.ic_launcher, "6", "666")
        val goods7 = Goods(R.mipmap.ic_launcher, "7", "777")
        val goods8 = Goods(R.mipmap.ic_launcher, "8", "888")
        list.apply {
            add(goods1)
            add(goods2)
            add(goods3)
            add(goods4)
            add(goods5)
            add(goods6)
            add(goods7)
            add(goods8)
            add(goods1)
        }
        return list
    }

    override fun showGoodsView(onLoaderListener: IGoodsModel.OnLoaderListener) {
        onLoaderListener.onComplete(getData())
    }

}