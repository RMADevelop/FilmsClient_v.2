package com.example.romanm.filmsclientv2.presentation.mvp.model.mapper;

import com.example.romanm.filmsclientv2.domain.models.FilmDetailDomain;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmDetailPresentation;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by RomanM on 21.11.2017.
 */

public class FilmDetailMapperPresentation {

    @Inject
    public FilmDetailMapperPresentation() {
    }

    public FilmDetailPresentation transform(FilmDetailDomain filmDetailDomain) {
        FilmDetailPresentation filmDetail = null;
        if (filmDetailDomain != null) {
            filmDetail = new FilmDetailPresentation();
            filmDetail.setBackdropPath(filmDetailDomain.getBackdropPath());
            filmDetail.setBudget(filmDetailDomain.getBudget());
            filmDetail.setId(filmDetailDomain.getId());
            filmDetail.setOverview(filmDetailDomain.getOverview());
            filmDetail.setTitle(filmDetailDomain.getTitle());
            filmDetail.setVoteAverage(filmDetailDomain.getVoteAverage());
            filmDetail.setPosterPath(filmDetailDomain.getPosterPath());
            filmDetail.setReleaseDate(filmDetailDomain.getReleaseDate());
        }
        return filmDetail;
    }

    public List<FilmDetailPresentation> transform(List<FilmDetailDomain> filmDetailDomainList) {
        List<FilmDetailPresentation> list = new ArrayList<>();
        for (FilmDetailDomain filmDetailDomain : filmDetailDomainList) {
            list.add(transform(filmDetailDomain));
        }
        return list;
    }
}

