package com.example.romanm.filmsclientv2.utils.Schedulers;

import io.reactivex.Scheduler;

/**
 * Created by RomanM on 23.11.2017.
 */

public interface SchedulersManager {


        Scheduler getIo();

Scheduler getMainThread();
}
