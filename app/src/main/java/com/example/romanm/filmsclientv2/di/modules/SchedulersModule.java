package com.example.romanm.filmsclientv2.di.modules;

import com.example.romanm.filmsclientv2.utils.Schedulers.AppSchedulers;
import com.example.romanm.filmsclientv2.utils.Schedulers.SchedulersManager;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created by RomanM on 01.12.2017.
 */

@Module
public abstract class SchedulersModule {

    @Singleton
    @Binds
    public abstract SchedulersManager provideSchedulers(AppSchedulers appSchedulers);
}
