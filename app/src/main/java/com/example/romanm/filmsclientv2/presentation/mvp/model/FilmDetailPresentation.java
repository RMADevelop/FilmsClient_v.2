package com.example.romanm.filmsclientv2.presentation.mvp.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

/**
 * Created by RomanM on 21.11.2017.
 */

@AutoValue
public abstract class FilmDetailPresentation implements Parcelable {

    public static FilmDetailPresentation create(String backdropPath,
                                                          int budget,
                                                          int id,
                                                          String overview,
                                                          String posterPath,
                                                          String releaseDate,
                                                          String title,
                                                          float voteAverage) {
        return new AutoValue_FilmDetailPresentation(backdropPath,budget,id,overview,posterPath,releaseDate,title,voteAverage);

    }

    public abstract String backdropPath();
    public abstract int budget();

    public abstract int id();

    public abstract String overview();

    public abstract String posterPath();

    public abstract String releaseDate();

    public abstract String title();

    public abstract float voteAverage();

}
