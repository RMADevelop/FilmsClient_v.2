package com.example.romanm.filmsclientv2.presentation.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmDetailPresentation;

/**
 * Created by RomanM on 28.10.2017.
 */

public interface FilmInfoView extends MvpView {
    void setFilmInfo(FilmDetailPresentation film);

    void setItemViewPager(FilmDetailPresentation film);
}
