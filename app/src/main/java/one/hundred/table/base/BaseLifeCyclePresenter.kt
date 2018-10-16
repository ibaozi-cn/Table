package one.hundred.table.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log.d

/**
 * author: zhangzhanyong
 * created on: 2017/11/8 下午4:46
 * description:
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseLifeCyclePresenter(var baseLifeCycleView: BaseLifeCycleView? = null) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy() {
        baseLifeCycleView?.removeLifecycleObserver(this)
        baseLifeCycleView = null
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate() {

    }

    open fun <T> bindItemView(baseLifeCycleView: BaseLifeCycleView): T {
        this.baseLifeCycleView = baseLifeCycleView
        this.baseLifeCycleView?.addLifecycleObserver(this)
        return this as T
    }

}