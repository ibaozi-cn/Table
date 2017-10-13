package one.hundred.table.item.lib

/**
 * Created by zzy on 2017/10/13.
 */
data class ItemValidateResult(val isValidate: Boolean = true, val error: String? = null)


interface ItemValidateData {
    /**
     * 合法返回true
     * 不合法返回false
     */
    fun validateData(data: String?): ItemValidateResult
}

/**
 * 默认实现，不需要验证
 */
class DefaultValidateData() : ItemValidateData {
    override fun validateData(data: String?): ItemValidateResult = ItemValidateResult()
}

/**
 * 验证非空
 */
class EmptyValidateData() : ItemValidateData {

    override fun validateData(data: String?): ItemValidateResult {

        return if (data != null && data.isNotEmpty() && data.replace("\\s*", "") != "" && data != "null") {
            ItemValidateResult()
        } else {
            ItemValidateResult(false, "不能为空")
        }
    }

}

/**
 * 验证长度不能
 * 小于等于
 * @Param min，
 * 大于等于
 * @param max
 */
class LengthValidateData(val max: Int = Int.MAX_VALUE, val min: Int = Int.MIN_VALUE, private val itemValidateData: ItemValidateData = DefaultValidateData()) : ItemValidateData {

    override fun validateData(data: String?): ItemValidateResult {

        val result = itemValidateData.validateData(data)
        if (!result.isValidate) return result

        return if (data != null && data.length >= min && data.length <= max) {
            ItemValidateResult()
        } else {
            ItemValidateResult(false, if (max != min) "长度必须大于等于$min 并且小于等于$max" else "长度必须$min 位")
        }

    }

}