package com.example.romanm.filmsclientv2.presentation.mvp.presenters.PresentersImpl;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.repository.Repository;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.ReviewsPresenter;
import com.example.romanm.filmsclientv2.presentation.mvp.views.ReviewsView;
import com.example.romanm.filmsclientv2.data.source.remote.models.Reviews;

import java.util.List;

import javax.inject.Inject;

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
