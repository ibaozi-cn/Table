package one.hundred.table.item.lib

import android.content.Context
import android.view.View

/**
 * Created by zzy on 2017/10/13.
 */
fun View.Gone() {
    this.visibility = View.GONE
}

fun View.Visible() {
    this.visibility = View.VISIBLE
}

inline fun Boolean.runIfTrue(block: Boolean.() -> Unit): Boolean {
    if (this) {
        block()
    }
    return this
}

inline fun Boolean.runElse(block: Boolean.() -> Unit): Boolean {
    if (!this) {
        block()
    }
    return this
}

/**
 * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
 */
fun dip2px(context: Context, dpValue: Float): Int {
    val scale = context.resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}
