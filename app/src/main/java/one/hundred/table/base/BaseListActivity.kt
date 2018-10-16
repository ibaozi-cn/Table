package one.hundred.table.base

import android.content.Context
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
abstract class BaseListActivity : AppCompatActivity(), BaseLifeCycleView {

    var adapter = MultiTypeAdapter(AdapterSequence.ASC)

    lateinit var bottomView: LinearLayout

    lateinit var toolbar: Toolbar

    lateinit var appBarLayout: AppBarLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        coordinatorLayout {
            appBarLayout = appBarLayout {
                fitsSystemWindows = true
                toolbar = toolbar {
                    title = toolBarTitle()
                }.lparams(matchParent, dip(50)) {
                    scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
                }
            }.lparams(matchParent, wrapContent)
            relativeLayout {
                recyclerView {
                    layoutManager = getRVLayoutManager()
                    adapter = this@BaseListActivity.adapter
                }.lparams(matchParent, wrapContent) {
                    alignParentTop()
                    above(R.id.bottomId)
                }
                bottomView = linearLayout {
                    id = R.id.bottomId
                    orientation = LinearLayout.VERTICAL
                }.lparams(matchParent, wrapContent) {
                    padding = dip(8)
                    alignParentBottom()
                }
            }.lparams {
                behavior = AppBarLayout.ScrollingViewBehavior()
            }

        }
        initToolBarMenu(toolbar)
        initBottomView(bottomView)
    }

    /**
     * 初始化toolbar 标题
     */
    abstract fun toolBarTitle(): String

    /**
     * 初始化toolbar 菜单
     */
    abstract fun initToolBarMenu(toolbar: Toolbar)

    /**
     * 初始化底部view
     */
    abstract fun initBottomView(bottomView: LinearLayout)

    /**
     * 添加一项 Item
     */
    fun addItem(itemViewModel: ItemViewModel) {
        adapter.addOrUpdateItem(itemViewModel)
    }

    /**
     * 添加 Item集合
     */
    fun addItemList(list: List<ItemViewModel>) {
        adapter.addOrUpdateListItem(list)
    }

    /**
     * 添加BottomView
     */
    fun addBottomView(view: View) {
        bottomView.addView(view)
    }

    /*
     * 设置RecycleView的layoutManager
     */
    open fun getRVLayoutManager(): RecyclerView.LayoutManager = LinearLayoutManager(this)

    override fun getContext(): Context {
        return this
    }
}