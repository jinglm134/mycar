package com.jaylm.mycar.base

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.annotation.Nullable
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.jaylm.mycar.R
import com.jaylm.mycar.global.VariableInfo
import java.util.*

/**
 * Created by jaylm
 * on 2018/9/29.
 */
@Suppress("DEPRECATION")
abstract class BaseActivity : AppCompatActivity() {

    /*当前类名标签*/
    private lateinit var TAG: String
    /*当前Activity渲染的视图View*/
    private var mRootView: View? = null
    /**activity实例**/
    private lateinit var mActivity: BaseActivity
    /** 用于保存所有已打开的Activity*/
    private val listActivity = Stack<Activity>()
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
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

        //初始化
        if (mRootView == null) {
            mRootView = LayoutInflater.from(this).inflate(bindLayout(), null, false)
            setContentView(mRootView)
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
    protected open fun initView() {}
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


    override fun onDestroy() {
        super.onDestroy()
        if (listActivity.contains(this)) {
            listActivity.remove(this)
        }
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
}