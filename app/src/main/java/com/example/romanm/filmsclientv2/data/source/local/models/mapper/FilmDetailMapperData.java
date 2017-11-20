package com.example.romanm.filmsclientv2.data.source.local.models.mapper;

import com.example.romanm.filmsclientv2.data.source.local.models.FilmDetailLocal;
import com.example.romanm.filmsclientv2.data.source.remote.models.filmDetail.FilmDetail;
import com.example.romanm.filmsclientv2.domain.models.FilmDetailDomain;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by RomanM on 20.11.2017.
 */

public class FilmDetailMapperData {

    @Inject
    public FilmDetailMapperData() {
    }

    public FilmDetailDomain transformToDomain(FilmDetailLocal filmDetail) {
        FilmDetailDomain filmDetailDomain = null;
        if (filmDetail != null) {
            filmDetailDomain = new FilmDetailDomain();
            filmDetailDomain.setId(filmDetail.getId());
            filmDetailDomain.setTitle(filmDetail.getTitle());
            filmDetailDomain.setOverview(filmDetail.getOverview());
            filmDetailDomain.setBackdropPath(filmDetail.getBackdropPath());
            filmDetailDomain.setPosterPath(filmDetail.getPosterPath());
            filmDetailDomain.setBudget(filmDetail.getBudget());
            filmDetailDomain.setReleaseDate(filmDetail.getReleaseDate());
            filmDetailDomain.setVoteAverage(filmDetail.getVoteAverage());
        }
        return filmDetailDomain;
    }

    public List<FilmDetailDomain> transformListToDomain(List<FilmDetailLocal> filmDetailLocals) {
        List<FilmDetailDomain> domainList = new ArrayList<>();
        for (FilmDetailLocal filmDetailLocal : filmDetailLocals) {
            domainList.add(transformToDomain(filmDetailLocal));
        }
        return domainList;
    }
}
