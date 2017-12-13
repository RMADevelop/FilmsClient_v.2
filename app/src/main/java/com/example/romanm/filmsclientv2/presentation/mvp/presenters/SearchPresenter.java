package com.example.romanm.filmsclientv2.presentation.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.di.scopes.SearchScope;
import com.example.romanm.filmsclientv2.domain.exception.NoNetworkException;
import com.example.romanm.filmsclientv2.domain.interactors.search.SearchInteractor;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.model.mapper.FilmMapperPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.views.SearchView;
import com.example.romanm.filmsclientv2.utils.Schedulers.SchedulersManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by RomanM on 27.11.2017.
 */
@SearchScope
@InjectViewState
public class SearchPresenter extends MvpPresenter<SearchView> {

    private final SearchInteractor searchInteractor;

    private final FilmMapperPresentation mapper;

    private final SchedulersManager schedulers;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    public SearchPresenter(SearchInteractor searchInteractor, FilmMapperPresentation mapper, SchedulersManager schedulers) {
        this.searchInteractor = searchInteractor;
        this.mapper = mapper;
        this.schedulers = schedulers;
    }

    public void registerSearchObserver(Observable<String> searchObserver) {

        compositeDisposable.add(searchObserver
                .debounce(300, TimeUnit.MILLISECONDS)
                .filter(s -> !s.isEmpty())
                .distinctUntilChanged()
                .switchMapSingle(s -> searchInteractor.getSearchFilms(s, 1))
                .map(mapper::transform)
                .observeOn(schedulers.getMainThread())
                .subscribeWith(new DisposableObserver<List<FilmPresentation>>() {
                    @Override
                    public void onNext(List<FilmPresentation> filmPresentations) {
                        getViewState().setFilms(filmPresentations);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof NoNetworkException) {
                            // error on view
                        } else {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                }));

    }

    public void unRegister() {
        compositeDisposable.dispose();
    }
}
