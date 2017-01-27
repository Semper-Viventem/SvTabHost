package ru.semper_viventem.svtabhost.svtabhost.SvTabLib;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import ru.semper_viventem.svtabhost.svtabhost.example.fragments.ExampleFragment;

/**
 * @author Kulikov Konstantin
 * @since 27.01.2017.
 */

public class SvTabHostAdapter extends FragmentStatePagerAdapter {

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
        return new ExampleFragment().newInstance("lll"); //mData.get(position).getmFragment();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

}
