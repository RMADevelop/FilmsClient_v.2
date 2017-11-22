package com.example.romanm.filmsclientv2.data.source.remote.mapper;

import com.example.romanm.filmsclientv2.data.source.remote.models.Result;
import com.example.romanm.filmsclientv2.domain.models.FilmDomain;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by RomanM on 22.11.2017.
 */

public class FilmMapperRemote {

    @Inject
    public FilmMapperRemote() {
    }

    public FilmDomain transform(Result result) {
        FilmDomain filmDomain = null;
        if (result != null) {
            filmDomain = new FilmDomain();
            filmDomain.setId(result.getId());
            filmDomain.setTitle(result.getTitle());
            filmDomain.setOverview(result.getOverview());
            filmDomain.setBackdropPath(result.getBackdropPath());
            filmDomain.setPosterPath(result.getPosterPath());
            filmDomain.setOriginalTitle(result.getOriginalTitle());
            filmDomain.setPopularity(result.getPopularity());
            filmDomain.setReleaseDate(result.getReleaseDate());
            filmDomain.setVoteAverage(result.getVoteAverage());
            filmDomain.setVoteCount(result.getVoteCount());
        }
        return filmDomain;
    }

    public List<FilmDomain> transform(List<Result> list) {
        List<FilmDomain> filmDomainList = null;
        if (list != null) {
            filmDomainList = new ArrayList<>(list.size());
            for (Result result : list) {
                filmDomainList.add(transform(result));
            }
        }
        return filmDomainList;

    }
}
