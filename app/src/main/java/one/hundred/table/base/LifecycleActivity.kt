package one.hundred.table.base

import android.arch.lifecycle.LifecycleObserver

/**
 * Created by zzy on 2017/10/13.
 */
abstract class LifecycleActivity : BaseListActivity() {

    override fun removeLifecycleObserver(observer: LifecycleObserver) {
        removeLifeObserver(observer)
    }

    override fun addLifecycleObserver(observer: LifecycleObserver) {
        addLifeObserver(observer)
    }

    private val listObserver: MutableList<LifecycleObserver> = mutableListOf()

    /**
     * 添加观察者
     */
    private fun addLifeObserver(observer: LifecycleObserver) {
        listObserver.add(observer)
        lifecycle.addObserver(observer)
    }

    /**
     * 当前状态
     */
    fun getLifeCurrentState() = lifecycle.currentState

    /**
     * 删除某个观察者
     */
    private fun removeLifeObserver(observer: LifecycleObserver) {
        lifecycle.removeObserver(observer)
    }
}