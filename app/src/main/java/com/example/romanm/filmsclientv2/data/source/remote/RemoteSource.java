package com.example.romanm.filmsclientv2.data.source.remote;


import android.util.Log;

import com.example.romanm.filmsclientv2.data.Item;
import com.example.romanm.filmsclientv2.data.source.DataSource;
import com.example.romanm.filmsclientv2.pojo.Movie;
import com.example.romanm.filmsclientv2.pojo.SessionId;
import com.example.romanm.filmsclientv2.pojo.filmDetail.FilmDetail;
import com.example.romanm.filmsclientv2.retrofit.Server;

import io.reactivex.Maybe;
import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.romanm.filmsclientv2.utils.Const.URL_TMDb;


public class RemoteSource implements DataSource {


    private Retrofit retrofit;


    public RemoteSource(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public Single<Movie> loadMoviesNowPlaying() {
        return retrofit.create(Server.class).getMovie();
    }

    @Override
    public Single<Movie> loadPopular() {
        return retrofit.create(Server.class)
                .getPopular();
    }

    @Override
    public Single<Movie> loadTopRated() {
        return retrofit.create(Server.class)
                .getTopRated();
    }

    @Override
    public Single<Movie> loadUpcoming() {
        return retrofit.create(Server.class)
                .getUpcoming();
    }

    @Override
    public Maybe<FilmDetail> getFilmInfo(int id) {

        Log.v("remoteLocal", "fetch film");

        return retrofit.create(Server.class)
                .getFilmInfo(id);
    }

    @Override
    public Single<Movie> loadRecommended(int id) {

        return retrofit.create(Server.class)
                .getRecommended(id);
    }

    @Override
    public void saveFilmInfo(FilmDetail film) {

    }

    @Override
    public void saveItem(Item item) {

    }

    @Override
    public Single<Item> checkDb() {
        return null;
    }


}
