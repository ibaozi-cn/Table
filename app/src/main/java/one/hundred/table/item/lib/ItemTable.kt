package one.hundred.table.item.lib

import com.pape.adapter.ItemViewModel

/**
 * Created by zzy on 2017/10/13.
 */
abstract class ItemTable(val tableBean: ItemTableBean) : ItemViewModel {
    override fun getSortedId(): Long = tableBean.sortId
    open fun validateData(result: (String) -> Unit): Boolean = true
    override fun getItemUUID(): String = tableBean.itemUUID
}