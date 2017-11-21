package com.example.romanm.filmsclientv2.presentation.mvp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by RomanM on 21.11.2017.
 */

public class FilmDetailPresentation implements Parcelable{

    private String backdropPath;
    private int budget;
    private int id;
    private String overview;
    private String posterPath;
    private String releaseDate;
    private String title;
    private float voteAverage;

    public FilmDetailPresentation() {
    }

    protected FilmDetailPresentation(Parcel in) {
        backdropPath = in.readString();
        budget = in.readInt();
        id = in.readInt();
        overview = in.readString();
        posterPath = in.readString();
        releaseDate = in.readString();
        title = in.readString();
        voteAverage = in.readFloat();
    }

    public static final Creator<FilmDetailPresentation> CREATOR = new Creator<FilmDetailPresentation>() {
        @Override
        public FilmDetailPresentation createFromParcel(Parcel in) {
            return new FilmDetailPresentation(in);
        }

        @Override
        public FilmDetailPresentation[] newArray(int size) {
            return new FilmDetailPresentation[size];
        }
    };

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(backdropPath);
        parcel.writeInt(budget);
        parcel.writeInt(id);
        parcel.writeString(overview);
        parcel.writeString(posterPath);
        parcel.writeString(releaseDate);
        parcel.writeString(title);
        parcel.writeFloat(voteAverage);
    }
}
