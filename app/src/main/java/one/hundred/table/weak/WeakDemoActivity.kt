package one.hundred.table.weak

import android.support.v7.widget.Toolbar
import android.widget.LinearLayout
import one.hundred.table.base.BaseListActivity
import java.lang.ref.WeakReference

/**
 * Created by zzy on 2017/10/13.
 */
class WeakDemoActivity : BaseListActivity<WeakPresenter>() {

    override fun initToolBarMenu(toolbar: Toolbar) {
    }

    override fun initBottomView(bottomView: LinearLayout) {
    }

    override fun initPresenter(): WeakPresenter {
        return WeakPresenter(WeakReference(this))
    }

    override fun toolBarTitle() = "WeakDemoActivity"


}