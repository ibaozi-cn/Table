package one.hundred.table.life

import android.arch.lifecycle.LifecycleObserver
import com.pape.adapter.ItemViewModel
import one.hundred.table.base.BasePresenter
import one.hundred.table.item.lib.ItemTransformationFactory

/**
 * Created by zzy on 2017/10/13.
 */
class LifecyclePresenter : LifecycleObserver, BasePresenter {


    private val mapObserver: MutableMap<String, Any> = mutableMapOf()

    override fun initViewData(): List<ItemViewModel> {
        return ItemTransformationFactory.transformationViewData(textViewData(), mapObserver)
    }

}