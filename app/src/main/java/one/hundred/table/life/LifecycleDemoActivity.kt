package one.hundred.table.life

import android.support.v7.widget.Toolbar
import android.widget.LinearLayout
import android.widget.TextView
import one.hundred.table.base.LifecycleActivity
import one.hundred.table.item.lib.addMenu

/**
 * Created by zzy on 2017/10/13.
 */
class LifecycleDemoActivity : LifecycleActivity<LifecyclePresenter>() {

    private val textMapShow: TextView by lazy {
        TextView(this)
    }

    override fun initToolBarMenu(toolbar: Toolbar) {
        toolbar.addMenu("Show Map")
        toolbar.setOnMenuItemClickListener {
            appBarLayout.setExpanded(false)
            textMapShow.text = getPresenter().mapObserver.toString()
            true
        }
    }

    override fun initBottomView(bottomView: LinearLayout) {
        bottomView.addView(textMapShow)
    }

    override fun toolBarTitle() = "LifecycleDemoActivity"

    override fun initPresenter(): LifecyclePresenter {
        return LifecyclePresenter()
    }

}