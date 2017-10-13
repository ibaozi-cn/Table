package one.hundred.table.item

import android.graphics.drawable.Drawable
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.pape.adapter.ItemViewHolder
import one.hundred.table.R
import one.hundred.table.item.lib.ItemTable
import one.hundred.table.item.lib.ItemTableBean
import one.hundred.table.item.lib.ItemTableType
import one.hundred.table.item.lib.dip2px
import org.jetbrains.anko.textColor

/**
 * Created by zzy on 2017/10/13.
 */
class ItemText(tableBean: ItemTableBean, val onClick: ((ItemText) -> Unit)? = null) : ItemTable(tableBean) {

    private val itemType: ItemTableType.Text = tableBean.type as ItemTableType.Text
    private var dawdleLeft: Drawable? = null
    private var dawdleRight: Drawable? = null

    override fun bindData(holder: ItemViewHolder) {

        val text = holder.getView<TextView>(R.id.tv_item)
        text.text = tableBean.keyName

        text.textSize = itemType.textSize.toFloat()
        text.textColor = holder.context.resources.getColor(itemType.textColor)

        if (itemType.leftDrawble != null && dawdleLeft == null) {
            dawdleLeft = holder.context.resources.getDrawable(itemType.leftDrawble)
            dawdleLeft?.setBounds(0, 0, dawdleLeft!!.minimumWidth, dawdleLeft!!.minimumHeight)
        }
        if (itemType.rightDrawble != null && dawdleRight == null) {
            dawdleRight = holder.context.resources.getDrawable(itemType.rightDrawble)
            dawdleRight?.setBounds(0, 0, dawdleRight!!.minimumWidth, dawdleRight!!.minimumHeight)
        }
        text.setCompoundDrawables(dawdleLeft, null, dawdleRight, null)

        val layout = holder.itemView as LinearLayout
        val layoutParam = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParam.gravity = itemType.gravity
        text.layoutParams = layoutParam

        text.setPadding(dip2px(holder.context, itemType.paddLeft.toFloat()), 0,
                dip2px(holder.context, itemType.paddRight.toFloat()), 0)

        holder.itemView.setOnClickListener {
            onClick?.invoke(this)
        }
    }

    override fun getItemViewLayoutId(): Int = R.layout.item_text
}