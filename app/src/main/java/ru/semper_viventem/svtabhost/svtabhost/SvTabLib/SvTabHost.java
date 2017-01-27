package ru.semper_viventem.svtabhost.svtabhost.SvTabLib;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kulikov Konstantin
 * @since  27.01.2017.
 */

public class SvTabHost extends LinearLayout {

    private FragmentManager mFragmentManager;

    private int mCurrentTabId = 0;
    private List<SvTabPage> mTabList = new ArrayList<SvTabPage>();
    private ViewPager mViewPager;
    private SvTabHostAdapter mAdapter;

    public SvTabHost(Context context) {
        super(context);
    }

    public SvTabHost(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void initTabHost(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
        mAdapter = new SvTabHostAdapter(mFragmentManager);
        mViewPager = new ViewPager(getContext());

        addView(mViewPager);
    }

    private void updateView() {

    }

    public boolean AddTab(Fragment fragment, String title) {
        if (mViewPager == null || mFragmentManager == null) return false;

        mTabList.add(new SvTabPage(fragment, title));

        mAdapter.setData(mTabList);
        return true;
    }

}
