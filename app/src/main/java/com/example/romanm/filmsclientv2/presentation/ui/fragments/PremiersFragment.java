package com.example.romanm.filmsclientv2.presentation.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.romanm.filmsclientv2.R;
import com.example.romanm.filmsclientv2.di.ComponentManager;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.PremiersPresenter;
import com.example.romanm.filmsclientv2.presentation.mvp.views.PremiersView;
import com.example.romanm.filmsclientv2.presentation.ui.adapters.PremiersAdapterRV;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import static android.content.ContentValues.TAG;

public class PremiersFragment extends MvpAppCompatFragment implements PremiersView, PremiersAdapterRV.PremiersAdapterListener {


    @Inject
    @InjectPresenter
    PremiersPresenter presenter;
    PremiersFragmentListener listener;
    PremiersAdapterRV adapter;
    private Toolbar toolbar;

    public PremiersFragment() {
        // Required empty public constructor
    }

    public static PremiersFragment getInstance() {
        Bundle bundle = new Bundle();
        PremiersFragment fragment = new PremiersFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @ProvidePresenter
    PremiersPresenter providePresenter() {
        return presenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ComponentManager
                .getInstance()
                .createListComponent()
                .inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_premiers, container, false);

        initToolbar(view);
        initRV(view);
        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);

        super.onCreateOptionsMenu(menu, inflater);
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
        listener = null;
        super.onDetach();
    }


    private void initToolbar(View view) {
        toolbar = view.findViewById(R.id.toolbar_premiers);
        toolbar.inflateMenu(R.menu.main);
        MenuItem search = toolbar.getMenu().findItem(R.id.menu_search_film);

        search.setOnMenuItemClickListener(menuItem -> {
            listener.startSearch();
            return true;
        });
    }


    private void initRV(View view) {
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv_premiers);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new PremiersAdapterRV(getContext(), PremiersAdapterRV.PREMIERS, Collections.<FilmPresentation>emptyList(), this);
        rv.setAdapter(adapter);
    }

    @Override
    public void showPopulars(List<FilmPresentation> films) {
        Log.d(TAG, "showPopulars() returned: " + films);

        adapter.setMovies(films);
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

        void startSearch();

    }


}
