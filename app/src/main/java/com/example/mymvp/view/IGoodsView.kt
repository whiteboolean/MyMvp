package com.example.mymvp.view

import com.example.mymvp.Goods

interface IGoodsView : IBaseView {

    //显示文字，图片
    //加载进度条等
    //加载动画

    fun showGoodView(good:MutableList<Goods>)
}