package one.hundred.table.life

import one.hundred.table.base.LifecycleActivity

/**
 * Created by zzy on 2017/10/13.
 */
class LifecycleDemoActivity : LifecycleActivity<LifecyclePresenter>() {

    override fun toolBarTitle() = "LifecycleDemoActivity"

    override fun initPresenter(): LifecyclePresenter {
        return LifecyclePresenter()
    }

}