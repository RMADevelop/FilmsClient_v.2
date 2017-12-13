package com.example.romanm.filmsclientv2.presentation.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmDetailPresentation;

/**
 * Created by RomanM on 28.10.2017.
 */

public interface BaseInfoView extends MvpView {

    void setInfo(FilmDetailPresentation filmDetail);

}
