package com.example.romanm.filmsclientv2.di.component;

import com.example.romanm.filmsclientv2.di.modules.ContextModule;
import com.example.romanm.filmsclientv2.di.modules.DataModule;
import com.example.romanm.filmsclientv2.mvp.presenters.PremiersPresenter;
import com.example.romanm.filmsclientv2.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by RomanM on 25.10.2017.
 */
@Singleton
@Component(modules = {ContextModule.class, DataModule.class})
public interface AppComponent {
    void inject(PremiersPresenter premiersPresenter);
}
