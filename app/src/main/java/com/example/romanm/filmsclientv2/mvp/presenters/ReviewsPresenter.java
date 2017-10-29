package com.example.romanm.filmsclientv2.mvp.presenters;

import com.example.romanm.filmsclientv2.pojo.ReviewsWrapper;

import io.reactivex.Single;

/**
 * Created by RomanM on 29.10.2017.
 */

public interface ReviewsPresenter extends BasePresenter{

    void getReviews(int idFilm);
}
