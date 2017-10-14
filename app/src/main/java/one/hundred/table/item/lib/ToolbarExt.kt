package one.hundred.table.item.lib

import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.Toolbar


/**
 *
 * 项目名称：kanche-mars-android
 * 类描述：toolbar扩展
 * 创建人：zzy(zhanyong.zhang@kanche.com)
 * 创建时间：2017/9/20 上午11:14
 * 修改人：
 * 修改时间：2017/9/20 上午11:14
 * 修改备注：
 * @version
 *
 */
fun Toolbar.addMenu(vararg name: String) {
    name.forEach {
        menu.add(it).let {
            id = title.hashCode()
            it.setShowAsAction(MenuItemCompat.SHOW_AS_ACTION_IF_ROOM)
            //todo 可以继续扩展展 是否可点击，是否显示等等
        }
    }
}