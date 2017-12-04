package com.example.romanm.filmsclientv2.di.component;

import com.example.romanm.filmsclientv2.di.modules.ListModule;
import com.example.romanm.filmsclientv2.presentation.ui.fragments.PremiersFragment;

import dagger.Subcomponent;

/**
 * Created by RomanM on 01.12.2017.
 */
@Subcomponent(modules = ListModule.class)
public interface ListComponent {

    void inject(PremiersFragment premiersFragment);

}
