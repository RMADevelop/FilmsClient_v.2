package com.example.romanm.filmsclientv2.utils.Schedulers;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by RomanM on 23.11.2017.
 */
@Singleton
public class SchedulersManagerImpl implements SchedulersManager {


    @Inject
    public SchedulersManagerImpl() {
    }

    @Override
    public Scheduler getIo() {
        return Schedulers.io();
    }

    @Override
    public Scheduler getMainThread() {
        return AndroidSchedulers.mainThread();
    }
}
