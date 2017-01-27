package ru.semper_viventem.svtabhost.svtabhost.SvTabLib;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kulikov Konstantin
 * @since 27.01.2017.
 */

public class SvTabHostAdapter extends FragmentPagerAdapter {

    private List<SvTabPage> mData = new ArrayList<SvTabPage>();

    public SvTabHostAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setData(List<SvTabPage> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return mData.get(position).getmFragment();
    }

    @Override
    public int getCount() {
        return mData.size();
    }
}
