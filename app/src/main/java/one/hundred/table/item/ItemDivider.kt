package one.hundred.table.item

import com.pape.adapter.ItemViewHolder
import one.hundred.table.R
import one.hundred.table.item.lib.ItemTable
import one.hundred.table.item.lib.ItemTableBean

/**
 * Created by zzy on 2017/10/13.
 */
class ItemDivider(tableBean: ItemTableBean, val height: Int? = null) : ItemTable(tableBean) {

    override fun bindData(holder: ItemViewHolder) {
        height?.let {
            holder.itemView.layoutParams.height = it
        }
    }

    override fun getItemViewLayoutId(): Int = R.layout.item_divider
}