package com.example.romanm.filmsclientv2.domain.common;

import javax.inject.Inject;

/**
 * Created by RomanM on 19.11.2017.
 */

public class PaginationState {

    private int page = 1;

    private int index;

    private final int limit = 20;

    @Inject
    public PaginationState() {
    }

    public void nextPage() {
        page++;
        index += 20;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
