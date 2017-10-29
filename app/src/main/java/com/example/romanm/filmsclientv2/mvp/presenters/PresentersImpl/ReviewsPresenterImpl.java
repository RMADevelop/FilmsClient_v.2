package com.example.romanm.filmsclientv2.mvp.presenters.PresentersImpl;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.App;
import com.example.romanm.filmsclientv2.data.source.Repository;
import com.example.romanm.filmsclientv2.mvp.presenters.ReviewsPresenter;
import com.example.romanm.filmsclientv2.mvp.views.ReviewsView;
import com.example.romanm.filmsclientv2.pojo.Reviews;
import com.example.romanm.filmsclientv2.pojo.ReviewsWrapper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by RomanM on 29.10.2017.
 */
@InjectViewState
public class ReviewsPresenterImpl extends MvpPresenter<ReviewsView> implements ReviewsPresenter {

    @Inject
    Repository repository;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ReviewsPresenterImpl() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void getReviews(int idFilm) {
        repository.loadReviews(idFilm)
                .subscribeOn(Schedulers.io())
                .map(reviewsWrapper -> reviewsWrapper.getResults())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Reviews>>() {
                    @Override
                    public void onSuccess(List<Reviews> reviews) {
                        getViewState().showReviews(reviews);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }
}