package com.example.romanm.filmsclientv2.presentation.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmDetailPresentation;

/**
 * Created by RomanM on 28.10.2017.
 */

public interface FilmInfoView extends MvpView {
    void setFilmInfo(FilmDetailPresentation film);

    @StateStrategyType(SkipStrategy.class)
    void setItemViewPager(FilmDetailPresentation film);
}
