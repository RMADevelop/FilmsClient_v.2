package com.example.romanm.filmsclientv2.presentation.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.romanm.filmsclientv2.R;
import com.example.romanm.filmsclientv2.di.ComponentManager;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.SearchPresenter;
import com.example.romanm.filmsclientv2.presentation.mvp.views.SearchView;
import com.example.romanm.filmsclientv2.presentation.ui.adapters.PremiersAdapterRV;

import java.util.Collections;
import java.util.List;

import io.reactivex.subjects.BehaviorSubject;


public class SearchFragment extends MvpAppCompatFragment implements SearchView, PremiersAdapterRV.PremiersAdapterListener {


    private static final String BUNDLE_LAYOUT_MANAGER = "layout_manager";

    @InjectPresenter
    SearchPresenter presenter;

    private SearchFragmentListener listener;
    private RecyclerView searchRecyclerView;
    private PremiersAdapterRV adapterRV;
    private ImageView back;
    private ImageView clear;
    private EditText searchEditText;
    private BehaviorSubject<String> searchObserver = BehaviorSubject.create();

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance(boolean isAnim) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    SearchPresenter providePresenter() {
        return ComponentManager.getInstance()
                .createSearchComponent()
                .getPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        presenter.registerSearchObserver(searchObserver);
        initSearchField(view);
        initSearchRecycler(view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SearchFragmentListener) {
            listener = (SearchFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        listener = null;
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        presenter.unRegister();
        super.onDestroy();
    }

    private void initSearchField(View view) {

        initSearchEditText(view);
        initSearchButtons(view);

    }

    private void initSearchButtons(View view) {
        clear = view.findViewById(R.id.image_clear);
        clear.setOnClickListener(view1 -> presenter.clearButtonClick());

        back = view.findViewById(R.id.image_back);
        back.setOnClickListener(view1 -> presenter.clearButtonClick());
    }

    private void initSearchEditText(View view) {
        searchEditText = view.findViewById(R.id.text_search);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                clear.setVisibility(charSequence.toString().length() > 0 ? View.VISIBLE : View.INVISIBLE);
                searchObserver.onNext(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void initSearchRecycler(View view) {
        searchRecyclerView = view.findViewById(R.id.search_recycler);
        adapterRV = new PremiersAdapterRV(getContext(), PremiersAdapterRV.SEARCH, Collections.emptyList(), this);
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        searchRecyclerView.setAdapter(adapterRV);
    }

    @Override
    public void onItemClick(int idFilm) {
        listener.itemClick(idFilm);
    }

    @Override
    public void loadMore() {
    }

    @Override
    public void setFilms(List<FilmPresentation> list) {
        adapterRV.setSearchMovies(list);
    }

    @Override
    public void clearSearch() {
        searchEditText.clearFocus();
        clear.setVisibility(View.INVISIBLE);
        InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    @Override
    public void noNetworkConnection() {
        Snackbar.make(getView(), R.string.network_error, Snackbar.LENGTH_LONG).show();
    }

    public interface SearchFragmentListener {
        void itemClick(int idFilm);
    }
}
