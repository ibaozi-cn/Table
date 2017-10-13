package one.hundred.table.weak

import one.hundred.table.base.BaseListActivity

/**
 * Created by zzy on 2017/10/13.
 */
class WeakDemoActivity : BaseListActivity<WeakPresenter>() {

    override fun initPresenter(): WeakPresenter {
        return WeakPresenter()
    }

    override fun toolBarTitle() = "WeakDemoActivity"


}