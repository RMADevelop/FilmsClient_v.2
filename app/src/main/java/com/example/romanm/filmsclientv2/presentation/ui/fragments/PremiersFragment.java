package com.example.romanm.filmsclientv2.presentation.ui.fragments;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.romanm.filmsclientv2.App;
import com.example.romanm.filmsclientv2.R;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.PremiersPresenterImpl;
import com.example.romanm.filmsclientv2.presentation.mvp.views.PremiersView;
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

    private Toolbar toolbar;

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

        initToolbar(view);
        initRV(view);
        return view;
    }

    private void initToolbar(View view) {
        toolbar = view.findViewById(R.id.toolbar_premiers);
        toolbar.inflateMenu(R.menu.main);


        SearchManager searchManager = (SearchManager) getContext().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) toolbar.getMenu().findItem(R.id.menu_search_film).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setIconifiedByDefault(false);
//
//        MenuItem searchItem = menu.findItem(R.id.menu_search_film);
//        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("dfsdfsfsdfsd", "showPopulars() returned: ");

                Toast.makeText(getActivity(), "kk;", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("dfsdfsfsdfsd", "showPopulars() returned: ");

                Toast.makeText(getActivity(), "qq;", Toast.LENGTH_SHORT).show();

                return true;
            }
        });
//        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
    }


    private void initRV(View view) {
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv_premiers);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new PremiersAdapterRV(getContext(), Collections.<FilmPresentation>emptyList(), this);
        rv.setAdapter(adapter);
    }

    @Override
    public void showPopulars(List<FilmPresentation> films) {
        Log.d(TAG, "showPopulars() returned: " + films);

        adapter.setMovies(films);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.d("dfsdfsfsdfsd", "dsdddddddddddddddddddd() returned: ");

        inflater.inflate(R.menu.main, menu);


        SearchManager searchManager = (SearchManager) getContext().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search_film).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setIconifiedByDefault(false);
//
//        MenuItem searchItem = menu.findItem(R.id.menu_search_film);
//        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("dfsdfsfsdfsd", "showPopulars() returned: ");

                Toast.makeText(getActivity(), "kk;", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("dfsdfsfsdfsd", "showPopulars() returned: ");

                Toast.makeText(getActivity(), "qq;", Toast.LENGTH_SHORT).show();

                return true;
            }
        });
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
