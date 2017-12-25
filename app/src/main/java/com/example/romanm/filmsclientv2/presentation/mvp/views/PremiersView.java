package com.example.romanm.filmsclientv2.presentation.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmPresentation;

import java.util.List;

/**
 * Created by RomanM on 25.10.2017.
 */

public interface PremiersView extends MvpView {

    @StateStrategyType(AddToEndStrategy.class)
    void showPopulars(List<FilmPresentation> films);

    @StateStrategyType(SkipStrategy.class)
    void noNetworkConnectioin();
}
