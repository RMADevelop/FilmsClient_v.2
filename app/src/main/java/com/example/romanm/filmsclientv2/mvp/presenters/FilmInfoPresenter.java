package com.example.romanm.filmsclientv2.mvp.presenters;

import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.mvp.views.FilmInfoView;
import com.example.romanm.filmsclientv2.pojo.Result;

/**
 * Created by RomanM on 28.10.2017.
 */

public interface FilmInfoPresenter extends BasePresenter {

    void loadFilm(int idFilm);

}
