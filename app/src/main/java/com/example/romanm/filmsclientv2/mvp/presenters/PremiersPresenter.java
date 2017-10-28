package com.example.romanm.filmsclientv2.mvp.presenters;

import com.example.romanm.filmsclientv2.pojo.Result;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by RomanM on 26.10.2017.
 */

public interface PremiersPresenter extends BasePresenter {

    void getPremiersFilms();

}
