package one.hundred.table.base

import android.arch.lifecycle.LifecycleObserver

/**
 * Created by zzy on 2017/10/13.
 */
abstract class LifecycleActivity<P : BasePresenter> : BaseListActivity<P>() {

    private val listObserver: MutableList<LifecycleObserver> = mutableListOf()

    override fun onStart() {
        super.onStart()
        //将presenter注册为生命周期观察者
        val presenter = getPresenter()
        if (presenter is LifecycleObserver)
            addLifeObserver(presenter)
    }

    /**
     * 添加观察者
     */
    fun addLifeObserver(observer: LifecycleObserver) {
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
    fun removeLifeObserver(observer: LifecycleObserver) {
        lifecycle.removeObserver(observer)
    }

    /**
     * 主动释放所有观察者
     */
    override fun onDestroy() {
        listObserver.forEach {
            removeLifeObserver(it)
        }
        super.onDestroy()
    }

}