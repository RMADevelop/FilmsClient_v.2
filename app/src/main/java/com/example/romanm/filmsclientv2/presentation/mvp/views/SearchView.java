package com.example.romanm.filmsclientv2.presentation.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmPresentation;

import java.util.List;

/**
 * Created by RomanM on 27.11.2017.
 */

public interface SearchView extends MvpView {

    @StateStrategyType(AddToEndStrategy.class)
    void setFilms(List<FilmPresentation> list);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void clearSearch();

    @StateStrategyType(SkipStrategy.class)
    void noNetworkConnection();
}
