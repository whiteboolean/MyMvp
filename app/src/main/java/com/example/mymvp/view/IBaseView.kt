package com.example.mymvp.view

/**
 * View层的顶层接口
 */
interface IBaseView {
    fun showLoading(msg:String)
    fun dismissLoading()
    fun showErrorMessage(msg:String)
}