package one.hundred.table.life

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.LinearLayout
import android.widget.TextView
import one.hundred.table.base.LifePresenterBinder
import one.hundred.table.base.LifecycleActivity
import one.hundred.table.item.lib.addMenu

/**
 * Created by zzy on 2017/10/13.
 */
class LifecycleDemoActivity : LifecycleActivity() {


    private val presenter by lazy {
        LifePresenterBinder.bindView(this, LifecyclePresenter())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addItemList(presenter.initViewData());
    }


    private val textMapShow: TextView by lazy {
        TextView(this)
    }

    override fun initToolBarMenu(toolbar: Toolbar) {
        toolbar.addMenu("Show Map")
        toolbar.setOnMenuItemClickListener {
            appBarLayout.setExpanded(false)
            textMapShow.text = presenter.mapObserver.toString()
            true
        }
    }

    override fun initBottomView(bottomView: LinearLayout) {
        bottomView.addView(textMapShow)
    }

    override fun toolBarTitle() = "LifecycleDemoActivity"

}