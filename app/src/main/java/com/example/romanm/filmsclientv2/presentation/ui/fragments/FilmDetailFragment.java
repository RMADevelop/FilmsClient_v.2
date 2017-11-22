package com.example.romanm.filmsclientv2.presentation.ui.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.romanm.filmsclientv2.App;
import com.example.romanm.filmsclientv2.R;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmDetailPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.filmDetail.FilmInfoPresenterImpl;
import com.example.romanm.filmsclientv2.presentation.mvp.views.FilmInfoView;
import com.example.romanm.filmsclientv2.presentation.ui.adapters.ViewPagerAdapterFilmInfo;
import com.example.romanm.filmsclientv2.utils.Api;

import javax.inject.Inject;


public class FilmDetailFragment extends MvpAppCompatFragment implements FilmInfoView {


    private OnFragmentInteractionListener mListener;

    @Inject
    @InjectPresenter
    FilmInfoPresenterImpl filmInfoPresenter;

    @ProvidePresenter
    FilmInfoPresenterImpl provideFilmInfoPresenter() {
        return filmInfoPresenter;
    }

    private static final String ARG_ID_FILM = "EXTRA_ID_FILM";

    private int idFilm;

    private ImageView imagePoster;

    private Toolbar toolbar;

    private TabLayout tabLayout;

    private ViewPager viewPager;

    private ViewPagerAdapterFilmInfo pagerAdapterFilmInfo;

    public FilmDetailFragment() {
        // Required empty public constructor
    }

    public static FilmDetailFragment newInstance(int idFilm) {
        FilmDetailFragment fragment = new FilmDetailFragment();
        Log.d("dssdfsdfsfsdfsd", "newInstance() returned: " + fragment);
        Bundle args = new Bundle();
        args.putInt(ARG_ID_FILM, idFilm);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        App.plusFilmInfoComponent().inject(this);
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idFilm = getArguments().getInt(ARG_ID_FILM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_film_info, container, false);

        initToolbar(view);
        initPoster(view);

        filmInfoPresenter.loadFilm(idFilm);

        initTabLayout(view);
        initViewPager(view);
        return view;
    }

    private void initToolbar(View view) {
        toolbar = (Toolbar) view.findViewById(R.id.toolbar_film_info);
    }

    private void initPoster(View view) {
        imagePoster = (ImageView) view.findViewById(R.id.image_poster_film_info);
    }

    private void initTabLayout(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout_film_info);
    }

    private void initViewPager(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.view_pager_film_info);
//        pagerAdapterFilmInfo = new ViewPagerAdapterFilmInfo(getChildFragmentManager(), idFilm);
//        viewPager.setAdapter(pagerAdapterFilmInfo);
//
//        tabLayout.setupWithViewPager(viewPager);
    }


//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void setFilmInfo(FilmDetailPresentation film) {
        Log.d("sadfadfadfgafgagd", "setFilmInfo() returned: " + film);
        Glide.with(getContext())
                .load(Api.getBackPoster(film.getBackdropPath()))
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imagePoster);
    }

    @Override
    public void setItemViewPager(FilmDetailPresentation film) {

            pagerAdapterFilmInfo = new ViewPagerAdapterFilmInfo(getChildFragmentManager(), film);
            viewPager.setAdapter(pagerAdapterFilmInfo);
            tabLayout.setupWithViewPager(viewPager);

        Log.d("dssdfsdfsfsdfsd", "setItemViewPager() returned: " + pagerAdapterFilmInfo + "  "  + filmInfoPresenter);

    }

    public interface OnFragmentInteractionListener {

    }
}
