package com.example.mymvp.presenter

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.example.mymvp.Goods
import com.example.mymvp.model.IGoodsModel
import com.example.mymvp.view.IBaseView
import java.lang.ref.WeakReference

open class BasePresenter<T : IBaseView> : LifecycleObserver{
    
    companion object{
        private const val TAG = "BasePresenter"
    }
    //    var iGoodsView: IGoodsView? = view
    var iBaseView: WeakReference<T>? = null


    fun attach(view: T) {
        iBaseView = WeakReference(view)

    }

    fun detach() {
        iBaseView?.clear()
        iBaseView = null
    }

    
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.d(TAG, "onCreate: ")
    }
    
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        Log.d(TAG, "onStart: ")
    }
    
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        Log.d(TAG, "onResume: ")
    }
    
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestory(){
        Log.d(TAG, "onDestory: ")
    }

}