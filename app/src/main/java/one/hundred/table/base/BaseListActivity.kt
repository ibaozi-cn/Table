package one.hundred.table.base

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.LinearLayout
import com.pape.adapter.AdapterSequence
import com.pape.adapter.ItemViewModel
import com.pape.adapter.MultiTypeAdapter
import one.hundred.table.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by zzy on 2017/10/13.
 */
abstract class BaseListActivity<P : BasePresenter> : AppCompatActivity(), BaseView<P> {

    var adapter = MultiTypeAdapter(AdapterSequence.ASC)

    lateinit var bottomView: LinearLayout

    lateinit var toolbar: Toolbar

    private lateinit var presenterCache: P

    override fun onCreate(savedInstanceState: Bundle?) {
        coordinatorLayout {
            appBarLayout {
                fitsSystemWindows = true
                toolbar = toolbar {
                    title = toolBarTitle()
                }.lparams(matchParent, dip(50)) {
                    scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
                }
            }.lparams(matchParent, wrapContent)
            relativeLayout {
                bottomView = linearLayout {
                    id = R.id.bottomId
                    orientation = LinearLayout.VERTICAL
                }.lparams(matchParent, wrapContent) {
                    padding = dip(8)
                    alignParentBottom()
                }
                recyclerView {
                    layoutManager = getRVLayoutManager()
                    adapter = this@BaseListActivity.adapter
                }.lparams(matchParent, wrapContent) {
                    alignParentTop()
                    above(R.id.bottomId)
                }
            }.lparams {
                behavior = AppBarLayout.ScrollingViewBehavior()
            }

        }
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        setPresenter(initPresenter())
        initViewData()
    }

    abstract fun toolBarTitle(): String

    abstract fun initPresenter(): P

    override fun setPresenter(presenter: P) {
        this.presenterCache = presenter
    }

    override fun getPresenter(): P {
        return presenterCache
    }

    private fun initViewData() {
        addItemList(presenterCache.initViewData())
    }

    fun addItem(itemViewModel: ItemViewModel) {
        adapter.addItem(itemViewModel)
    }

    fun addItemList(list: List<ItemViewModel>) {
        adapter.addListItem(list)
    }

    fun addBottomView(view: View) {
        bottomView.addView(view)
    }

    inline fun <reified T : ItemViewModel> findItem(uuid: String): T? = adapter.findItem(uuid)

    open fun getRVLayoutManager(): RecyclerView.LayoutManager = LinearLayoutManager(this)
}