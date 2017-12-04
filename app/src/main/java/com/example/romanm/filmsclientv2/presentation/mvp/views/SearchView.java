package com.example.romanm.filmsclientv2.presentation.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmPresentation;

import java.util.List;

/**
 * Created by RomanM on 27.11.2017.
 */

public interface SearchView extends MvpView {


    void setFilms(List<FilmPresentation> list);
}
