package one.hundred.table.item.lib

/**
 * Created by zzy on 2017/10/13.
 */
fun tableBeanList(startIndex: Long = 0, vararg elements: ItemTableBean): List<ItemTableBean> {
    val list = arrayListOf<ItemTableBean>()
    if (elements.isEmpty()) return arrayListOf()
    return elements.mapIndexed { index, itemTableBean ->
        if (itemTableBean.sortId == Long.MIN_VALUE)
            itemTableBean.sortId = startIndex + index
        itemTableBean
    }.toList()
}

inline fun itemTableBean(block: ItemTableBean.() -> Unit): ItemTableBean {
    val item = ItemTableBean()
    item.block()
    return item
}