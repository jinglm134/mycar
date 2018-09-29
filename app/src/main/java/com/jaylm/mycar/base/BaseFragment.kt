package com.jaylm.mycar.base

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.annotation.Nullable
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by jaylm
 * on 2018/9/29.
 */
abstract class BaseFragment : Fragment() {

    private var rootView: View? = null
    private var mCurrentFragment: Fragment? = null

    private var hasConfig: Boolean = false//确保initView只执行一次，因为fragment恢复时,onCreateView等生命周期方法会多次执行
    /*默认可见,用于懒加载*/
    private var hasVisible = true


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            rootView = inflater.inflate(bindLayout(), container, false)
        }
        //缓存的rootView需要判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        val parent = rootView!!.parent
        if (parent != null) {
            (parent as ViewGroup).removeView(rootView)
        }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onVisible()
    }

    /*使用viewpager的FragmentPagerAdapter时，会调用setUserVisibleHint,实现懒加载*/
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            hasVisible = true
            onVisible()
        } else {
            hasVisible = false
        }
    }

    private fun onVisible() {
        if (isVisible && rootView != null && !hasConfig) {
            /*onViewCreated 和 setUserVisibleHint 均可能调用该方法,该方法只被执行一次.
              onViewCreated:未使用FragmentPagerAdapter加载的fragment ，或者adapter中的第一个fragment
              setUserVisibleHint：使用FragmentPagerAdapter加载的fragment,且非adapter中的第一个fragment*/
            hasConfig = true
            initView()//初始化view
            setListener()//设置监听
            bindData()//绑定数据

        }
    }

    @LayoutRes
    protected abstract fun bindLayout(): Int

    protected open fun initView() {}
    protected open fun setListener() {}
    protected open fun bindData() {}


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
        val adapter = object : FragmentPagerAdapter(childFragmentManager) {
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
        val manager = childFragmentManager
        val transaction = manager.beginTransaction()
        // 如有当前在使用的->隐藏当前的
        if (mCurrentFragment != null) {
            transaction.hide(mCurrentFragment!!)
        }
        // toFragment之前添加使用过->显示出来
        if (manager.findFragmentByTag(tag) != null) {
            transaction.show(toFragment)
        } else {// toFragment还没添加使用过->添加上去
            transaction.add(flId, toFragment, tag)
        }
        transaction.commitAllowingStateLoss()
        // toFragment更新为当前的
        mCurrentFragment = toFragment
    }
}