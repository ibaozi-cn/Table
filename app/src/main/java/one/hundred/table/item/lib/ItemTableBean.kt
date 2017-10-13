package one.hundred.table.item.lib

import java.util.*
/**
 * Created by zzy on 2017/10/13.
 */
data class ItemTableBean(
        /**
         * item 绝对标示，如果重复，在UI上不会被重新加载
         */
        var itemUUID: String = UUID.randomUUID().toString(),
        /**
         * 对应 服务端字段名
         */
        var key: String = "",
        /**
         * 对应 item的标题
         */
        var keyName: String = "",
        /**
         * 页面类型
         */
        var type: ItemTableType = ItemTableType.Divider(),
        /**
         * 是否删除
         */
        var isDelete: Boolean = false,
        /**
         * 排序 默认正序
         */
        var sortId: Long = Long.MIN_VALUE

)