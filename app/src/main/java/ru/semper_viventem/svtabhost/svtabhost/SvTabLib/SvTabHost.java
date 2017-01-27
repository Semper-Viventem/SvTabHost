package ru.semper_viventem.svtabhost.svtabhost.SvTabLib;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.List;

/**
 * @author Kulikov Konstantin
 * @since  27.01.2017.
 */

public class SvTabHost extends LinearLayout {

    private Context mContext;

    private int mCurrentTabId;
    private List<SvTabPage> mTabList;
    private ViewPager mViewPager;

    public SvTabHost(Context context) {
        super(context);

        
    }

    public SvTabHost(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


}
