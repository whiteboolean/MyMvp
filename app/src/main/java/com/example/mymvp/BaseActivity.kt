package com.example.mymvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mymvp.presenter.BasePresenter
import com.example.mymvp.view.IBaseView

abstract class BaseActivity<T : BasePresenter<*>, V : IBaseView> : AppCompatActivity() ,IBaseView{

    lateinit var presenter: T


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
//        presenter.attach(this)
    }

    abstract fun createPresenter(): T
    fun registerSDK() {}
    fun unregisterSDK() {}
    fun init() {}


    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
        unregisterSDK()
    }
}