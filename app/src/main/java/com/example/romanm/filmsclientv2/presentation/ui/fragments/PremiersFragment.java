package com.example.romanm.filmsclientv2.presentation.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.romanm.filmsclientv2.App;
import com.example.romanm.filmsclientv2.R;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.PresentersImpl.PremiersPresenterImpl;
import com.example.romanm.filmsclientv2.presentation.mvp.views.PremiersView;
import com.example.romanm.filmsclientv2.data.source.remote.models.Result;
import com.example.romanm.filmsclientv2.presentation.ui.adapters.PremiersAdapterRV;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import static android.content.ContentValues.TAG;

public class PremiersFragment extends MvpAppCompatFragment implements PremiersView, PremiersAdapterRV.PremiersAdapterListener {


    @Inject
    @InjectPresenter
    PremiersPresenterImpl presenter;

    @ProvidePresenter
    PremiersPresenterImpl providePresenter() {
        return presenter;
    }


    PremiersFragmentListener listener;


    public static final String ARG_TOP_RATED = "ARG_TOP_RATED";
    public static final String ARG_POPULAR = "ARG_POPULAR";
    public static final String ARG_UPCOMMING = "ARG_UPCOMMING";

    private static final String KEY_TYPE = "KEY_TYPE";

    PremiersAdapterRV adapter;


    public PremiersFragment() {
        // Required empty public constructor
    }


    public static PremiersFragment getInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_TYPE, type);
        PremiersFragment fragment = new PremiersFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        App.getAppComponent().inject(this);

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_premiers, container, false);


        initRV(view);
        return view;
    }


    private void initRV(View view) {
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv_premiers);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new PremiersAdapterRV(getContext(), Collections.<Result>emptyList(), this);
        rv.setAdapter(adapter);
    }

    @Override
    public void showPopulars(List<Result> films) {
        Log.d(TAG, "showPopulars() returned: " + films);

        adapter.setMovies(films);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PremiersFragmentListener) {
            listener = (PremiersFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement BaseInfoFragmentListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onItemClick(int idFilm) {
        listener.startFilmInfo(idFilm);

    }

    @Override
    public void loadMore() {
        presenter.getPremiersFilms();
    }


    public interface PremiersFragmentListener {

        void startFilmInfo(int idFilm);
    }


}
