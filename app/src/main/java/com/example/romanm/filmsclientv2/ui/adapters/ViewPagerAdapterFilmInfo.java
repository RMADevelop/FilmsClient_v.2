package com.example.romanm.filmsclientv2.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.romanm.filmsclientv2.ui.fragments.BaseInfoFragment;

/**
 * Created by RomanM on 28.10.2017.
 */

public class ViewPagerAdapterFilmInfo extends FragmentPagerAdapter {

    private int idFilm;

    public ViewPagerAdapterFilmInfo(FragmentManager fm, int idFilm) {
        super(fm);
        this.idFilm = idFilm;
    }

    @Override
    public Fragment getItem(int position) {
        return BaseInfoFragment.newInstance(idFilm);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "SECTION";
    }
}
