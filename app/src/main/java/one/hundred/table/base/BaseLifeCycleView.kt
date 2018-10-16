package one.hundred.table.base

import android.arch.lifecycle.LifecycleObserver
import android.content.Context

/**
 * author: zhangzhanyong
 * created on: 2017/12/7 下午4:59
 * description:
 */
interface BaseLifeCycleView {
    fun removeLifecycleObserver(observer: LifecycleObserver)
    fun addLifecycleObserver(observer: LifecycleObserver)
    fun getContext(): Context
}