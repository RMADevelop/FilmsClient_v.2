package com.example.romanm.filmsclientv2.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.example.romanm.filmsclientv2.pojo.filmDetail.FilmDetail;

/**
 * Created by RomanM on 28.10.2017.
 */

public interface BaseInfoView extends MvpView {

    void setInfo(FilmDetail filmDetail);

}
