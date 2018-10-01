package com.jaylm.mycar.base

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.annotation.Nullable
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.*
import com.jaylm.mycar.R
import com.jaylm.mycar.global.VariableInfo
import com.lzy.okgo.OkGo
import kotlinx.android.synthetic.main.activity_base.*
import java.util.*

/**
 * Created by jaylm
 * on 2018/9/29.
 */
@Suppress("DEPRECATION")
abstract class BaseActivity : AppCompatActivity() {

    /*当前类名标签*/
    protected lateinit var TAG: String
    /*当前Activity渲染的视图View*/
    protected var mRootView: View? = null
    /**activity实例**/
    protected lateinit var mActivity: BaseActivity
    /** 用于保存所有已打开的Activity*/
    private val listActivity = Stack<Activity>()
    private var currentFragment: Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        TAG = this::class.java.simpleName

        //设置是否全屏
        if (VariableInfo.isAllowFullScreen) {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
            requestWindowFeature(Window.FEATURE_NO_TITLE)
        }

        //设置横竖屏
        requestedOrientation = if (VariableInfo.isPortrait) {
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT//竖屏
        } else {
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE//横屏
        }

        //设置是否沉浸式状态栏
        if (VariableInfo.isCJSBar) {
            steepStatusBar()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//android 5.0及以上,设置状态栏颜色
            window.statusBarColor = resources.getColor(R.color.colorPrimaryDark)
        }
        setContentView(R.layout.activity_base)
        initToolbar()
        //初始化
        if (mRootView == null) {
            mRootView = LayoutInflater.from(mActivity).inflate(bindLayout(), fl_content, true)
            if (intent.extras != null) {
                initParams(intent.extras)//获取bundle中的数据
            }
            initView()//初始化view
            setListener()//设置监听
            bindData()//绑定数据
        }
    }

    @LayoutRes
    protected abstract fun bindLayout(): Int

    protected open fun initParams(bundle: Bundle) {}
    protected open fun initView() {

    }
    protected open fun setListener() {}
    protected open fun bindData() {}


    /**
     * 设置沉浸状态栏
     */
    private fun steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            // 透明导航栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }
    }


    /**
     * 携带数据的页面跳转
     *
     * @param clz class
     * @param bundle bundle
     */
    private fun startActivity(clz: Class<*>, bundle: Bundle?) {
        val intent = Intent()
        intent.setClass(this, clz)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    /**
     *  携带数据并可以返回数据的页面跳转
     * @param cls class
     * @param bundle bundle
     * @param requestCode requestCode
     */
    private fun startActivityForResult(cls: Class<*>, bundle: Bundle?, requestCode: Int) {
        val intent = Intent()
        intent.setClass(this, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivityForResult(intent, requestCode)
    }


    /**
     * TabLayout+ViewPager+Fragment,设置tabLayout并返回adapter
     *
     * @param tabLayout             tabLayout
     * @param viewPager             viewPager
     * @param mTitleList            标题
     * @param mFragmentList         fragment
     * @param num                   设置预加载数
     * @param isMode                设置是否横向滑动
     * @return                      adapter
     */
    fun getAdapter(tabLayout: TabLayout, viewPager: ViewPager, mTitleList: List<String>, mFragmentList: List<Fragment>, num: Int, isMode: Boolean): FragmentPagerAdapter {

        val count = Math.min(mTitleList.size, mFragmentList.size)//页面数量

        for (i in mTitleList.indices) {
            tabLayout.addTab(tabLayout.newTab().setText(mTitleList[i]))
        }
        viewPager.offscreenPageLimit = num //设置预加载个数
        val adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment? {
                return mFragmentList[position]
            }

            override fun getCount(): Int {
                return count
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return mTitleList[position % count]
            }
        }

        viewPager.adapter = adapter
        viewPager.currentItem = 0//设置当前加载页面
        tabLayout.setupWithViewPager(viewPager)
        if (isMode) {
            //设置可以滑动
            tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        }
        return adapter
    }

    //Fragment替换(隐藏当前的,显示现在的,用过的将不会重新destory与create)
    protected fun smartReplaceFragment(@IdRes flId: Int, toFragment: Fragment, @Nullable tag: String = toFragment.javaClass.simpleName) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        // 如有当前在使用的->隐藏当前的
        if (currentFragment != null) {
            transaction.hide(currentFragment!!)
        }
        // toFragment之前添加使用过->显示出来
        if (manager.findFragmentByTag(tag) != null) {
            transaction.show(toFragment)
        } else {// toFragment还没添加使用过->添加上去
            transaction.add(flId, toFragment, tag)
        }
        transaction.commitAllowingStateLoss()
        // toFragment更新为当前的
        currentFragment = toFragment
    }


    //toolbar 初始化
    private fun initToolbar() {
        setSupportActionBar(toolbar)
        val actionBar = this.supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)//显示返回图标
            actionBar.setDisplayShowTitleEnabled(false)//不显示应用图标
        }
    }

    //toolbar 返回键
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //点击back键finish当前activity
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }

    //设置title
    protected fun setHeader(title: CharSequence) {
        tv_title.text = title
    }

    //隐藏title
    protected fun hideHeader() {
        toolbar.visibility = View.GONE
    }

    //onDestroy
    override fun onDestroy() {
        super.onDestroy()
        OkGo.getInstance().cancelTag(this)
        if (listActivity.contains(this)) {
            listActivity.remove(this)
        }
    }

    //退出应用
    protected fun exit() {
        for (i in 0..listActivity.size) {
            listActivity[i].finish()
        }
    }

    //Tag
    fun getTag(): String {
        return TAG
    }


}