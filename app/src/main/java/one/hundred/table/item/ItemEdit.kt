package one.hundred.table.item

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import com.pape.adapter.ItemViewHolder
import one.hundred.table.R
import one.hundred.table.item.lib.*

/**
 * Created by zzy on 2017/10/13.
 */
class ItemEdit(tableBean: ItemTableBean, val observer: (String, String) -> Unit) : ItemTable(tableBean) {

    var itemType: ItemTableType.TextEdit = tableBean.type as ItemTableType.TextEdit

    override fun bindData(holder: ItemViewHolder) {

        val textView = holder.getView<TextView>(R.id.tv_item)

        tableBean.keyName.isEmpty().runIfTrue {
            textView.Gone()
        }.runElse {
            textView.Visible()
            textView.text = tableBean.keyName
        }

        val edit = holder.getView<EditText>(R.id.et_item)
        edit.inputType = itemType.inputType
        edit.isEnabled = itemType.isEnable

        itemType.editFilters?.let {
            edit.filters = it.toTypedArray()
        }

        if (itemType.isEnable)
            edit.hint = "请输入"
        else
            edit.hint = ""

        if (edit.tag is TextWatcher) {
            edit.removeTextChangedListener(edit.tag as TextWatcher)
        }

        val value = itemType.defaultEditValue as? String

        if (value == null) {
            edit.setText("")
        } else {
            edit.setText(value)
        }

        val textWarche = object : TextWatcher {

            override fun afterTextChanged(p0: Editable) {
                if (p0.isNotEmpty()) {
                    itemType.defaultEditValue = p0.toString()
                    observer(tableBean.key, p0.toString())
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        }

        edit.tag = textWarche
        edit.addTextChangedListener(textWarche)

    }

    override fun validateData(result: (String) -> Unit): Boolean {
        val text = itemType.defaultEditValue.toString()
        val validate = itemType.validateData.validateData(text)
        if (!validate.isValidate) {
            result(tableBean.keyName + validate.error!!)
            return false
        }
        return true
    }

    override fun getItemViewLayoutId(): Int = R.layout.item_text_edit

}