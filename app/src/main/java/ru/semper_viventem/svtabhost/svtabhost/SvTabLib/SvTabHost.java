package ru.semper_viventem.svtabhost.svtabhost.SvTabLib;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import ru.semper_viventem.svtabhost.svtabhost.R;

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
    private SvTabNavigation mNavigation;

    public SvTabHost(Context context) {
        super(context);
    }

    public SvTabHost(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void initTabHost(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
        mAdapter = new SvTabHostAdapter(mFragmentManager);
        mViewPager = new ViewPager(getContext());
        mViewPager.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mViewPager.setAdapter(mAdapter);
        mNavigation = new SvTabNavigation(getContext());

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                mNavigation.switchToItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        updateView();
    }

    private void updateView() {
        //TODO updateView

        final SvTabNavigation.OnSwitchTabListener switchTabListener = new SvTabNavigation.OnSwitchTabListener() {
            @Override
            public void onSwitchListener(int position) {
                mViewPager.setCurrentItem(position);
            }
        };

        removeAllViews();
        addView(mNavigation.getTabView(switchTabListener));
        addView(mViewPager);
    }

    public boolean addTab(Fragment fragment, String title) {
        if (mViewPager == null || mFragmentManager == null) return false;

        mTabList.add(new SvTabPage(fragment, title));

        mAdapter.setData(mTabList);
        mNavigation.setmData(mTabList);

        updateView();
        return true;
    }

}
