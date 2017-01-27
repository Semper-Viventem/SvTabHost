package ru.semper_viventem.svtabhost.svtabhost.SvTabLib;


import android.support.v4.app.Fragment;

/**
 * @author Kulikov Konstantin
 * @since  27.01.2017.
 */

public class SvTabPage {
    private final Fragment mFragment;
    private final String mTitle;

    public SvTabPage(Fragment mFragment, String mTitle) {
        this.mFragment = mFragment;
        this.mTitle = mTitle;
    }

    public Fragment getmFragment() {
        return mFragment;
    }

    public String getmTitle() {
        return mTitle;
    }
}
