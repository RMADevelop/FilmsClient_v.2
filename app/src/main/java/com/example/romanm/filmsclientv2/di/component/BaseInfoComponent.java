package com.example.romanm.filmsclientv2.di.component;

import com.example.romanm.filmsclientv2.presentation.ui.fragments.BaseInfoFragment;

import dagger.Subcomponent;

/**
 * Created by RomanM on 15.11.2017.
 */

@Subcomponent
public interface BaseInfoComponent {

    void inject(BaseInfoFragment baseInfoFragment);
}
