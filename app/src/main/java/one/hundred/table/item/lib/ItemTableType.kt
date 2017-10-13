package one.hundred.table.item.lib

import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.text.InputFilter
import android.text.InputType
import android.view.Gravity
import one.hundred.table.R

/**
 * Created by zzy on 2017/10/13.
 */
sealed class ItemTableType {
    /**
     * 间隔线
     */
    data class Divider(
            val height: Int? = null) : ItemTableType()

    /**
     * 纯文本
     */
    data class Text(
            @ColorRes
            val textColor: Int = R.color.colorPrimaryDark,
            val textSize: Int = 14, //sp
            val gravity: Int = Gravity.CENTER_VERTICAL,
            val paddLeft: Int = 0, //dp
            val paddRight: Int = 0,
            @DrawableRes
            val leftDrawble: Int? = null,
            @DrawableRes
            val rightDrawble: Int? = null) : ItemTableType()

    /**
     * 文本编辑框
     */
    data class TextEdit(
            val inputType: Int = InputType.TYPE_CLASS_TEXT,
            val validateData: ItemValidateData = DefaultValidateData(),
            var defaultEditValue: Any? = "",
            val isEnable: Boolean = true,
            val editFilters: List<InputFilter>? = null) : ItemTableType()

    /**
     * 文本选择框
     * mapValue 不为空时将value映射到map中
     */
    data class TextSelect(
            var mapValue: String? = null,
            val selectList: List<Map<String, String>> = emptyList(),
            var defaultValue: Any? = "",
            val validateData: ItemValidateData = DefaultValidateData()) : ItemTableType()

    /**
     * 处理跳转事件view
     */
    data class TextAction(
            val aciton: String,
            @DrawableRes
            val actionDrawble: Int = R.drawable.ic_item_more,
            val actionStatus: String = "",
            val validateData: ItemValidateData = DefaultValidateData()
    ) : ItemTableType()


}
