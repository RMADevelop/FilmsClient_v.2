package com.example.romanm.filmsclientv2.data.source.remote.mapper;

import com.example.romanm.filmsclientv2.data.source.local.models.FilmDetailLocal;
import com.example.romanm.filmsclientv2.data.source.remote.models.filmDetail.FilmDetail;
import com.example.romanm.filmsclientv2.domain.models.FilmDetailDomain;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by RomanM on 20.11.2017.
 */

public class FilmDetailMapperRemote {
    @Inject
    public FilmDetailMapperRemote() {
    }

    public FilmDetailLocal transformToLocal(FilmDetail filmDetail) {
        FilmDetailLocal filmdetailLocal = null;
        if (filmDetail != null) {
            filmdetailLocal = new FilmDetailLocal();
            filmdetailLocal.setId(filmDetail.getId());
            filmdetailLocal.setTitle(filmDetail.getTitle());
            filmdetailLocal.setOverview(filmDetail.getOverview());
            filmdetailLocal.setBackdropPath(filmDetail.getBackdropPath());
            filmdetailLocal.setPosterPath(filmDetail.getPosterPath());
            filmdetailLocal.setBudget(filmDetail.getBudget());
            filmdetailLocal.setReleaseDate(filmDetail.getReleaseDate());
            filmdetailLocal.setVoteAverage(filmDetail.getVoteAverage());
        }
        return filmdetailLocal;
    }

    public List<FilmDetailLocal> transformToLocal(List<FilmDetail> filmDetailLocals) {
        List<FilmDetailLocal> localList = new ArrayList<>();
        for (FilmDetail filmDetailLocal : filmDetailLocals) {
            localList.add(transformToLocal(filmDetailLocal));
        }
        return localList;
    }
}
