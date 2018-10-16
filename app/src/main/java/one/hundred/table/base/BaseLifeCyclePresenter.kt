package one.hundred.table.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log
import android.util.Log.d

/**
 * author: zhangzhanyong
 * created on: 2017/11/8 下午4:46
 * description:
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseLifeCyclePresenter(var baseLifeCycleView: BaseLifeCycleView? = null) : LifecycleObserver {

    /**
     * 监听Activity onDestroy
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy() {
        Log.d("OnLifecycleEvent", "onViewDestroy")

    }
    /**
     * 监听Activity onCreate
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate() {
        Log.d("OnLifecycleEvent", "onViewCreate")
    }

    /**
     * 监听Activity onStart
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onViewStart() {
        Log.d("OnLifecycleEvent", "onViewStart")
    }

    /**
     * 监听Activity onStop
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onViewStop() {
        Log.d("OnLifecycleEvent", "onViewStop")
        baseLifeCycleView?.removeLifecycleObserver(this)
        baseLifeCycleView = null
    }

    open fun <T> bindItemView(baseLifeCycleView: BaseLifeCycleView): T {
        this.baseLifeCycleView = baseLifeCycleView
        this.baseLifeCycleView?.addLifecycleObserver(this)
        return this as T
    }

}