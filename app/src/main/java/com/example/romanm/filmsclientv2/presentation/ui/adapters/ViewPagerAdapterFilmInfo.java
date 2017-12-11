package com.example.romanm.filmsclientv2.presentation.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmDetailPresentation;
import com.example.romanm.filmsclientv2.presentation.ui.fragments.BaseInfoFragment;

/**
 * Created by RomanM on 28.10.2017.
 */

public class ViewPagerAdapterFilmInfo extends FragmentPagerAdapter {

    private FilmDetailPresentation film;

    public ViewPagerAdapterFilmInfo(FragmentManager fm, FilmDetailPresentation film) {
        super(fm);
        this.film = film;
    }

    @Override
    public Fragment getItem(int position) {
        return BaseInfoFragment.newInstance(film);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Info";
            case 1:
                return "Actors";
            case 2:
                return "Reviews";
            default:
                return "Error";
        }
    }

    public void setFilm(FilmDetailPresentation film) {
        this.film = film;
    }
}
