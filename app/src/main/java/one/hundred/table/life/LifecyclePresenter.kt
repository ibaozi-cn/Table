package one.hundred.table.life

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log
import com.pape.adapter.ItemViewModel
import one.hundred.table.base.BaseLifeCyclePresenter
import one.hundred.table.item.factory.ItemTransformationFactory
import one.hundred.table.item.map.MapDemo
import one.hundred.table.item.map.ServerData
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

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
                            baseLifeCycleView?.getContext()?.longToast("Action onClick")
                        }
                    }
                })
    }
}