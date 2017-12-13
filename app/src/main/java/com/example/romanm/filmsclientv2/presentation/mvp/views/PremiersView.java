package com.example.romanm.filmsclientv2.presentation.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmPresentation;

import java.util.List;

/**
 * Created by RomanM on 25.10.2017.
 */

public interface PremiersView extends MvpView {

    void showPopulars(List<FilmPresentation> films);
}
