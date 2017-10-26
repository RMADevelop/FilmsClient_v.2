package com.example.romanm.filmsclientv2.di.modules;

import com.example.romanm.filmsclientv2.data.source.remote.RemoteSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RomanM on 26.10.2017.
 */
@Module
public class RemoteDataModule {

    String baseUrl;

    public RemoteDataModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

//    @Provides
//    @Singleton
//    Server provideApi(Retrofit retrofit) {
//        return retrofit.create(Server.class);
//    }

    @Provides
    @Singleton
    RemoteSource provideRemoteSource(Retrofit retrofit){
        return new RemoteSource(retrofit);
    }

}
