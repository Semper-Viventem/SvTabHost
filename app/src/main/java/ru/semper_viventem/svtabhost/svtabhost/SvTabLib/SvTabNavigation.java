package ru.semper_viventem.svtabhost.svtabhost.SvTabLib;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kulikov Konstantin
 * @since 28.01.2017.
 */

public class SvTabNavigation {

    private final Context mContext;

    private int mCurrentTabId = 0;

    private List<SvTabPage> mData = new ArrayList<>();
    private List<TextView> mTabList = new ArrayList<>();

    public void setmData(List<SvTabPage> data) {
        mData = data;
    }

    public SvTabNavigation(Context mContext) {
        this.mContext = mContext;
    }

    public View getTabView(final OnSwitchTabListener onSwitchTabListener) {

        final HorizontalScrollView hScrollView = new HorizontalScrollView(mContext);
        hScrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        final LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        hScrollView.addView(linearLayout);

        mTabList = new ArrayList<>();
        for (int i = 0; i < mData.size(); i++) {
            final TextView tabView = new TextView(mContext);
            tabView.setTextSize(18);
            tabView.setBackgroundColor(Color.WHITE); //TODO collor
            tabView.setText(mData.get(i).getmTitle());

            final int finalI = i;
            tabView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onSwitchTabListener.onSwitchListener(finalI);
                    switchToItem(finalI);
                }
            });

            mTabList.add(tabView);
            linearLayout.addView(tabView);
        }

        switchToItem(mCurrentTabId);

        return hScrollView;
    }

    public void switchToItem(int pageId) {
        if (pageId+1 > mTabList.size()) return;
        mCurrentTabId = pageId;

        for (int i = 0; i < mTabList.size(); i++) {
            mTabList.get(i).setBackgroundColor(Color.WHITE);
        }

        mTabList.get(pageId).setBackgroundColor(Color.GRAY);
    }

    interface OnSwitchTabListener {
        void onSwitchListener(int position);
    }
}
