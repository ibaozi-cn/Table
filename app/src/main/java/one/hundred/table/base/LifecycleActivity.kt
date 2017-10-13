package one.hundred.table.base

import android.arch.lifecycle.LifecycleObserver

/**
 * Created by zzy on 2017/10/13.
 */
abstract class LifecycleActivity<P : BasePresenter> : BaseListActivity<P>() {

    private val listObserver: MutableList<LifecycleObserver> = mutableListOf()

    fun addLifeObserver(observer: LifecycleObserver) {
        listObserver.add(observer)
        lifecycle.addObserver(observer)
    }

    fun getLifeCurrentState() = lifecycle.currentState

    fun removeLifeObserver(observer: LifecycleObserver) {
        lifecycle.removeObserver(observer)
    }

    override fun onDestroy() {
        listObserver.forEach {
            removeLifeObserver(it)
        }
        super.onDestroy()
    }

}