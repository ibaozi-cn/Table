package one.hundred.table.life

import android.text.InputFilter
import android.text.InputType
import one.hundred.table.item.lib.*

/**
 * Created by zzy on 2017/10/13.
 */
fun textViewData(defaultMap: MutableMap<String, Any> = mutableMapOf()) = tableBeanList(
        0,
        itemTableBean {
            keyName = "甲方信息"
            type = ItemTableType.Text()
        },
        itemTableBean {
            key = "name"
            keyName = "客户姓名*"
            type = ItemTableType.TextEdit(
                    validateData = EmptyValidateData(),
                    defaultEditValue = defaultMap["name"])

        },
        itemTableBean {
            key = "old"
            keyName = "客户年龄*"
            type = ItemTableType.TextEdit(
                    validateData = EmptyValidateData(),
                    defaultEditValue = defaultMap["old"])

        },
        itemTableBean {
            key = "customerIdentity"
            keyName = "身份证号*"
            type = ItemTableType.TextEdit(
                    inputType = InputType.TYPE_NUMBER_FLAG_SIGNED,
                    validateData = LengthValidateData(18, 18),
                    editFilters = listOf(InputFilter.LengthFilter(18)))
        },
        itemTableBean {

        }
        ,
        itemTableBean {
            keyName = "乙方信息"
            type = ItemTableType.Text()
        }
        ,
        itemTableBean {
            key = "carDealers"
            keyName = "车商姓名*"
            type = ItemTableType.TextEdit(
                    validateData = EmptyValidateData(),
                    defaultEditValue = defaultMap["carDealers"])
        }
        ,
        itemTableBean {
            key = "carNum"
            keyName = "车商编号"
            type = ItemTableType.TextSelect(
                    selectList = listOf(mapOf("2" to "2", "3" to "3")),
                    validateData = EmptyValidateData()
            )
        },
        itemTableBean { },
        itemTableBean {
            key = "action"
            keyName = "照片"
            type = ItemTableType.TextAction(
                    aciton = ACTION_PHOTO,
                    actionStatus = "2张",
                    validateData = EmptyValidateData()
            )
        }
)

const val ACTION_PHOTO = "action_photo"
