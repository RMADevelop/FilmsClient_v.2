package com.example.romanm.filmsclientv2.repository;

import android.util.Log;

import com.example.romanm.filmsclientv2.data.source.local.Local;
import com.example.romanm.filmsclientv2.data.source.local.models.mapper.FilmDetailMapperData;
import com.example.romanm.filmsclientv2.data.source.remote.Remote;
import com.example.romanm.filmsclientv2.data.source.remote.mapper.FilmDetailMapperRemote;
import com.example.romanm.filmsclientv2.data.source.remote.mapper.FilmMapperRemote;
import com.example.romanm.filmsclientv2.data.source.remote.models.Movie;
import com.example.romanm.filmsclientv2.data.source.remote.models.ReviewsWrapper;
import com.example.romanm.filmsclientv2.data.source.remote.models.filmDetail.FilmDetail;
import com.example.romanm.filmsclientv2.domain.models.FilmDetailDomain;
import com.example.romanm.filmsclientv2.domain.models.FilmDomain;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.functions.Function;

/**
 * Created by Roma on 09.09.2017.
 */
@Singleton
public class Repository implements DataSource {

    private final Local local;

    private final Remote remote;

    private FilmDetailMapperRemote filmDetailMapperRemote;

    private FilmDetailMapperData filmDetailMapperData;

    private FilmMapperRemote filmMapperRemote;

    @Inject
    public Repository(Local local, Remote remote, FilmDetailMapperRemote filmDetailMapperRemote, FilmDetailMapperData filmDetailMapperData, FilmMapperRemote filmMapperRemote) {
        this.local = local;
        this.remote = remote;
        this.filmDetailMapperRemote = filmDetailMapperRemote;
        this.filmDetailMapperData = filmDetailMapperData;
        this.filmMapperRemote = filmMapperRemote;
    }

    @Override
    public Single<Movie> loadMoviesNowPlaying() {
        return remote.loadMoviesNowPlaying();
    }

    @Override
    public Single<List<FilmDomain>> loadPopular(int page) {
        return remote.loadPopular(page)
                .map(movie -> filmMapperRemote.transform(movie.getResults()));
    }

    @Override
    public Single<Movie> loadTopRated() {
        return remote.loadTopRated();
    }

    @Override
    public Single<Movie> loadUpcoming() {
        return remote.loadUpcoming();
    }

    @Override
    public Single<List<FilmDomain>> getSearchFilms(String query, int page) {
        return remote.getSearchFilms(query, page)
                .map(movie -> filmMapperRemote.transform(movie.getResults()));
    }

    @Override
    public Maybe<FilmDetailDomain> getFilmInfo(int id) {
        return Maybe.concat(
                local.getFilmInfo(id),
                remote.getFilmInfo(id)
                        .doOnSuccess(this::saveFilmInfo)
                        .map(filmDetail -> filmDetailMapperRemote.transformToLocal(filmDetail))
        )
                .firstElement()
                .map(filmDetailLocal -> filmDetailMapperData.transformToDomain(filmDetailLocal));
    }

    @Override
    public Single<Movie> loadRecommended(int id) {
        return remote.loadRecommended(id);
    }

    @Override
    public Single<ReviewsWrapper> loadReviews(int idFilm) {
        return remote.loadReviews(idFilm);
    }

    @Override
    public void saveFilmInfo(FilmDetail film) {
        local.saveFilmInfo(filmDetailMapperRemote.transformToLocal(film));
        Log.v("remoteLocal", "save film");
    }
}
