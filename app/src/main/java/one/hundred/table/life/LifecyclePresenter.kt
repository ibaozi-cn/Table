package one.hundred.table.life

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log
import com.pape.adapter.ItemViewModel
import one.hundred.table.base.BaseLifeCyclePresenter
import one.hundred.table.item.factory.ItemTransformationFactory
import one.hundred.table.item.map.MapDemo
import one.hundred.table.item.map.ServerData

/**
 * Created by zzy on 2017/10/13.
 */
class LifecyclePresenter(val mapObserver: MutableMap<String, Any> = mutableMapOf()) : BaseLifeCyclePresenter() {

    fun initViewData(): List<ItemViewModel> {
        return ItemTransformationFactory.transformationViewData(
                textViewData(MapDemo().map(ServerData("TestName", "TestOld")).map),
                mapObserver,
                actionClick = {
                    when (it.itemType.aciton) {
                        ACTION_PHOTO -> {
                            Log.d("Action", "Action onClick")
                        }
                    }
                })
    }

    /**
     * 监听Activity onDestroy
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onViewDestroy() {
        Log.d("OnLifecycleEvent", "onViewDestroy")
        //适当释放不必要资源
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
    }
}