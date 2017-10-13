package one.hundred.table.item

import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.widget.TextView
import com.pape.adapter.ItemViewHolder
import one.hundred.table.R
import one.hundred.table.item.lib.ItemTable
import one.hundred.table.item.lib.ItemTableBean
import one.hundred.table.item.lib.ItemTableType

/**
 * Created by zzy on 2017/10/13.
 */
class ItemSelect(tableBean: ItemTableBean, private val observer: (String, String) -> Unit,
                 val itemSelectClick: ((ItemSelect) -> Unit)? = null
) : ItemTable(tableBean) {

    val itemType: ItemTableType.TextSelect = tableBean.type as ItemTableType.TextSelect
    private var listSelectData: List<Map<String, String>> = itemType.selectList
    private var listValues: Array<CharSequence> = emptyArray()

    init {
        updateSelectData(listSelectData)
    }

    override fun bindData(holder: ItemViewHolder) {

        val textView = holder.getView<TextView>(R.id.tv_item)
        textView.text = tableBean.keyName

        val select = holder.getView<TextView>(R.id.tv_select)
        val value = itemType.defaultValue as? String
        if (value != null) {
            select.text = value
        } else {
            select.text = ""
        }
        if (select.text.isEmpty())
            select.hint = "请选择"

        select.setOnClickListener {
            itemSelectClick?.invoke(this)
            if (listValues.isNotEmpty()) {
                AlertDialog.Builder(holder.context).setItems(listValues, DialogInterface.OnClickListener { _, i ->
                    select.text = listValues[i].also {
                        itemType.defaultValue = it
                    }
                    observer(
                            tableBean.key,
                            getKey(listValues[i].toString())
                    )
                    itemType.mapValue?.let {
                        observer(
                                it,
                                select.text.toString()
                        )
                    }
                }).create().show()
            } else {
//                holder.context.toast("没有数据")
            }
        }
    }

    fun updateSelectData(data: List<Map<String, String>>) {
        listSelectData = data
        listValues = parseValueData()
    }

    private fun parseValueData(): Array<CharSequence> {
        val listResult = mutableListOf<String>()
        listSelectData.forEach {
            it.values.forEach {
                listResult.add(it)
            }
        }
        return listResult.toTypedArray()
    }

    private fun getKey(value: String): String {
        var key = ""
        listSelectData.forEach {
            it.map {
                if (it.value == value) {
                    key = it.key
                }
            }
        }
        return key
    }

    override fun validateData(result: (String) -> Unit): Boolean {
        val text = itemType.defaultValue.toString()
        val validate = itemType.validateData.validateData(text)
        if (!validate.isValidate) {
            result(tableBean.keyName + validate.error!!)
            return false
        }
        return true
    }

    override fun getItemViewLayoutId(): Int = R.layout.item_text_select

}