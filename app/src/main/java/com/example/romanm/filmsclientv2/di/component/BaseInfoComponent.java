package com.example.romanm.filmsclientv2.di.component;

import com.example.romanm.filmsclientv2.di.modules.filmDetail.BaseInfoModule;
import com.example.romanm.filmsclientv2.di.scopes.PresenterScope;
import com.example.romanm.filmsclientv2.presentation.ui.fragments.BaseInfoFragment;

import dagger.Subcomponent;

/**
 * Created by RomanM on 15.11.2017.
 */

@PresenterScope
@Subcomponent(modules = {BaseInfoModule.class})
public interface BaseInfoComponent {

    void inject(BaseInfoFragment baseInfoFragment);
}
