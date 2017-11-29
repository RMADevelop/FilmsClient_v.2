package com.example.romanm.filmsclientv2.di.component;

import com.example.romanm.filmsclientv2.di.scopes.SearchScope;
import com.example.romanm.filmsclientv2.presentation.ui.fragments.SearchFragment;

import dagger.Subcomponent;

/**
 * Created by RomanM on 27.11.2017.
 */
@SearchScope
@Subcomponent
public interface SearchComponent {

    void inject(SearchFragment searchFragment);
}
