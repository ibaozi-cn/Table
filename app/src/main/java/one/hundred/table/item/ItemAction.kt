package one.hundred.table.item

import android.graphics.drawable.Drawable
import android.widget.TextView
import com.pape.adapter.ItemViewHolder
import one.hundred.table.R
import one.hundred.table.item.lib.ItemTable
import one.hundred.table.item.lib.ItemTableBean
import one.hundred.table.item.lib.ItemTableType

/**
 * Created by zzy on 2017/10/13.
 */
class ItemAction(tableBean: ItemTableBean, val onClick: ((ItemAction) -> Unit)? = null) : ItemTable(tableBean) {

    val itemType: ItemTableType.TextAction = tableBean.type as ItemTableType.TextAction
    private var drawable: Drawable? = null

    override fun bindData(holder: ItemViewHolder) {

        val actionStatus = holder.getView<TextView>(R.id.tv_action_status)
        actionStatus.text = itemType.actionStatus

        val actionName = holder.getView<TextView>(R.id.tv_action_name)
        actionName.text = tableBean.keyName

        if (drawable == null) {
            drawable = holder.context.resources.getDrawable(itemType.actionDrawble)
            drawable?.setBounds(0, 0, drawable!!.minimumWidth, drawable!!.minimumHeight)
        }
        actionStatus.setCompoundDrawables(null, null, drawable, null)

        holder.itemView.setOnClickListener {
            onClick?.invoke(this)
        }
    }

    override fun getItemViewLayoutId(): Int = R.layout.item_tv_tvimg

    override fun validateData(result: (String) -> Unit): Boolean {
        val text = itemType.actionStatus
        val validate = itemType.validateData.validateData(text)
        if (!validate.isValidate) {
            result(tableBean.keyName + validate.error!!)
            return false
        }
        return true
    }
}