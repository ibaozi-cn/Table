package one.hundred.table.item

import android.content.DialogInterface
import android.graphics.Color
import android.support.v7.app.AlertDialog
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import com.pape.adapter.ItemViewHolder
import one.hundred.table.R
import one.hundred.table.item.factory.ItemSelectDataFactory
import one.hundred.table.item.lib.ItemTable
import one.hundred.table.item.lib.ItemTableBean
import one.hundred.table.item.lib.ItemTableType

/**
 * Created by zzy on 2017/10/13.
 */
class ItemSelect(tableBean: ItemTableBean, private val observer: (String, String) -> Unit,
                 private val itemSelectClick: ((ItemSelect) -> Unit)? = null
) : ItemTable(tableBean) {

    val itemType: ItemTableType.TextSelect = tableBean.type as ItemTableType.TextSelect
    private var listSelectData: List<Map<String, String>> = mutableListOf()
    private var listValues: Array<CharSequence> = emptyArray()

    init {
        ItemSelectDataFactory.getData(itemType.selectType, {
            updateSelectData(it)
        })
    }

    override fun bindData(holder: ItemViewHolder) {

        val textView = holder.getView<TextView>(R.id.tv_item)

        if (tableBean.keyName.contains("*")) {
            val spannable = SpannableString(tableBean.keyName)
            val index = tableBean.keyName.indexOf("*")
            spannable.setSpan(ForegroundColorSpan(Color.RED), index, index + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            textView.text = spannable
        } else {
            textView.text = tableBean.keyName
        }

        val select = holder.getView<TextView>(R.id.tv_select)
        val value = itemType.defaultValue as? String
        if (value != null) {
            select.text = value
        } else {
            select.text = ""
        }
        if (select.text.isEmpty())
            select.hint = "请选择"

        select.gravity = itemType.selectTextGravity

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