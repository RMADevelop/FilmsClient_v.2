package com.example.romanm.filmsclientv2.presentation.mvp.presenters.filmDetail;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.domain.interactors.filmDetail.FilmInfoInteractor;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmDetailPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.model.mapper.FilmDetailMapperPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.views.FilmInfoView;
import com.example.romanm.filmsclientv2.utils.Schedulers.SchedulersManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;


@InjectViewState
public class FilmInfoPresenter extends MvpPresenter<FilmInfoView> {

    private FilmInfoInteractor filmInfoInteractor;

    private FilmDetailMapperPresentation mapper;

    private SchedulersManager schedulersManager;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    public FilmInfoPresenter(FilmInfoInteractor filmInfoInteractor, FilmDetailMapperPresentation mapper, SchedulersManager schedulersManager) {
        this.filmInfoInteractor = filmInfoInteractor;
        this.mapper = mapper;
        this.schedulersManager = schedulersManager;
    }

    public void loadFilm(int idFilm) {
        compositeDisposable.add(filmInfoInteractor.getFilmDetail(idFilm)
                .toSingle()
                .map(mapper::transform)
                .observeOn(schedulersManager.getMainThread())
                .subscribeWith(new DisposableSingleObserver<FilmDetailPresentation>() {
                    @Override
                    public void onSuccess(FilmDetailPresentation filmDetailPresentation) {
                        getViewState().setFilmInfo(filmDetailPresentation);
                        getViewState().setItemViewPager(filmDetailPresentation);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                }));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
