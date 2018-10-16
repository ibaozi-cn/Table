package one.hundred.table.base


/**
 * author: zhangzhanyong
 * created on: 2018/1/17 下午6:50
 * description:
 */
object LifePresenterBinder {

    fun <T : BaseLifeCyclePresenter> bindView(baseLifeCycleView: BaseLifeCycleView, t: T) =
            t.bindItemView<T>(baseLifeCycleView)

}