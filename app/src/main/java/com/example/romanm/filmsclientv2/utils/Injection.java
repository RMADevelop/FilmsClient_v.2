package com.example.romanm.filmsclientv2.utils;

import android.content.Context;

import com.example.romanm.filmsclientv2.data.source.Repository;
import com.example.romanm.filmsclientv2.data.source.local.LocalDataRoom;
import com.example.romanm.filmsclientv2.data.source.local.LocalSource;
import com.example.romanm.filmsclientv2.data.source.preference.SharedPref;
import com.example.romanm.filmsclientv2.data.source.remote.RemoteSource;

/**
 * Created by Roma on 09.09.2017.
 */

public class Injection {
 public static Repository provideRepository(Context context){
     LocalDataRoom db = LocalDataRoom.getInstance(context.getApplicationContext());
     return Repository.getInstance(LocalSource.getInstance(db.getDAO()), RemoteSource.getInstance(), SharedPref.getInstanse(context));
 }
}
