package com.example.romanm.filmsclientv2.presentation.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.example.romanm.filmsclientv2.data.source.remote.models.filmDetail.FilmDetail;

/**
 * Created by RomanM on 28.10.2017.
 */

public interface FilmInfoView extends MvpView {
    void setFilmInfo(FilmDetail film);
}
