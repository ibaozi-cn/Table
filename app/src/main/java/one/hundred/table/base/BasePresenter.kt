package one.hundred.table.base

import com.pape.adapter.ItemViewModel

/**
 * Created by zzy on 2017/10/13.
 */
interface BasePresenter {
    fun initViewData(): List<ItemViewModel>
}