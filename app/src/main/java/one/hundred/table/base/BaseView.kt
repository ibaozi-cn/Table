package one.hundred.table.base

/**
 * Created by zzy on 2017/10/13.
 */
interface BaseView<P : BasePresenter> {
    fun setPresenter(presenter: P)
    fun getPresenter(): P
}