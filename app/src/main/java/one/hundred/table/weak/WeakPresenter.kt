package one.hundred.table.weak

import com.pape.adapter.ItemViewModel
import one.hundred.table.base.BasePresenter
import one.hundred.table.item.lib.ItemTransformationFactory
import one.hundred.table.life.textViewData
import java.lang.ref.WeakReference

/**
 * Created by zzy on 2017/10/13.
 */
class WeakPresenter(val weakReference: WeakReference<WeakDemoActivity>, override val mapObserver: MutableMap<String, Any> = mutableMapOf()) : BasePresenter {

    override fun initViewData() : List<ItemViewModel>{
        return ItemTransformationFactory.transformationViewData(textViewData(), mapObserver)
    }

}