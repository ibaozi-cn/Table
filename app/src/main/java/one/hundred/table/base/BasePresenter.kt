package one.hundred.table.base

import com.pape.adapter.ItemViewModel

/**
 * Created by zzy on 2017/10/13.
 */
interface BasePresenter {
    /**
     * 页面数据自动映射到该map中
     */
    val mapObserver: MutableMap<String, Any>

    /**
     * 组织页面数据 并展示
     */
    fun initViewData(): List<ItemViewModel>

}