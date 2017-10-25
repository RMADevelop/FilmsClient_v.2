package com.example.romanm.filmsclientv2.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by RomanM on 25.10.2017.
 */
@Module
public class ContextModule {
    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }
}
