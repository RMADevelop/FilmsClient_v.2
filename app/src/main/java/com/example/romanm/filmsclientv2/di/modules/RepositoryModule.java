package com.example.romanm.filmsclientv2.di.modules;

import com.example.romanm.filmsclientv2.data.source.Repository;
import com.example.romanm.filmsclientv2.data.source.local.LocalSource;
import com.example.romanm.filmsclientv2.data.source.remote.RemoteSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by RomanM on 25.10.2017.
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public Repository provideRepository(LocalSource local, RemoteSource remote) {
        return new Repository(local,remote);
    }

}
