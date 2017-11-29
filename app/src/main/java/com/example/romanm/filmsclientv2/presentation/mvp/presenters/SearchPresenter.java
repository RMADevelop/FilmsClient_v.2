package com.example.romanm.filmsclientv2.presentation.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.data.source.remote.models.Movie;
import com.example.romanm.filmsclientv2.data.source.remote.models.Result;
import com.example.romanm.filmsclientv2.domain.interactors.search.SeaerchInteractorImpl;
import com.example.romanm.filmsclientv2.domain.interactors.search.SearchInteractor;
import com.example.romanm.filmsclientv2.presentation.mvp.views.SearchView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by RomanM on 27.11.2017.
 */
@InjectViewState
public class SearchPresenter extends MvpPresenter<SearchView> {

    private final SearchInteractor searchInteractor;

    private Observable<String> searchObserver;

    @Inject
    public SearchPresenter(SeaerchInteractorImpl searchInteractor) {
        this.searchInteractor = searchInteractor;
    }


    public void registerSearchObserver(Observable<String> searchObserver) {
        this.searchObserver = searchObserver;

        searchObserver
                .debounce(500, TimeUnit.MILLISECONDS)

                .filter(s -> !s.isEmpty())
                .distinctUntilChanged()
                .switchMapSingle(s -> searchInteractor.getSearchFilms(s, 1))
                .map(Movie::getResults)
                .subscribeWith(new DisposableObserver<List<Result>>() {
                    @Override
                    public void onNext(List<Result> list) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
