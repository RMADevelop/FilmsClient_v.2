package com.example.romanm.filmsclientv2.presentation.mvp.model.mapper;

import com.example.romanm.filmsclientv2.domain.models.FilmDomain;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmPresentation;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by RomanM on 22.11.2017.
 */

public class FilmMapperPresentation {

    @Inject
    public FilmMapperPresentation() {
    }

    public FilmPresentation transform(FilmDomain filmDomain) {
        FilmPresentation filmPresentation = null;
        if (filmDomain != null) {
            filmPresentation = new FilmPresentation();
            filmPresentation.setId(filmDomain.getId());
            filmPresentation.setTitle(filmDomain.getTitle());
            filmPresentation.setOverview(filmDomain.getOverview());
            filmPresentation.setBackdropPath(filmDomain.getBackdropPath());
            filmPresentation.setPosterPath(filmDomain.getPosterPath());
            filmPresentation.setOriginalTitle(filmDomain.getOriginalTitle());
            filmPresentation.setPopularity(filmDomain.getPopularity());
            filmPresentation.setReleaseDate(filmDomain.getReleaseDate());
            filmPresentation.setVoteAverage(filmDomain.getVoteAverage());
            filmPresentation.setVoteCount(filmDomain.getVoteCount());
        }
        return filmPresentation;
    }

    public List<FilmPresentation> transform(List<FilmDomain> list) {
        List<FilmPresentation> filmPresentationList = null;
        if (list != null) {
            filmPresentationList = new ArrayList<>(list.size());
            for (FilmDomain filmDomain : list) {
                filmPresentationList.add(transform(filmDomain));
            }
        }
        return filmPresentationList;

    }
}
