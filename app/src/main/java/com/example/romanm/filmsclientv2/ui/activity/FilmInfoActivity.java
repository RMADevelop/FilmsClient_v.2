package com.example.romanm.filmsclientv2.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.romanm.filmsclientv2.R;
import com.example.romanm.filmsclientv2.mvp.presenters.PresentersImpl.FilmInfoPresenterImpl;
import com.example.romanm.filmsclientv2.mvp.views.FilmInfoView;
import com.example.romanm.filmsclientv2.pojo.filmDetail.FilmDetail;
import com.example.romanm.filmsclientv2.ui.adapters.ViewPagerAdapterFilmInfo;
import com.example.romanm.filmsclientv2.ui.fragments.BaseInfoFragment;
import com.example.romanm.filmsclientv2.utils.Api;

public class FilmInfoActivity extends MvpAppCompatActivity implements FilmInfoView, BaseInfoFragment.BaseInfoFragmentListener {

    private static final String EXTRA_ID_FILM = "EXTRA_ID_FILM";

    @InjectPresenter
    FilmInfoPresenterImpl presenter;

    private int idFilm;

    private ImageView imagePoster;

    private Toolbar toolbar;

    private TabLayout tabLayout;

    private ViewPager viewPager;

    private ViewPagerAdapterFilmInfo pagerAdapterFilmInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_info);

        initToolbar();
        initPoster();


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.getInt(EXTRA_ID_FILM) != -1) {
                idFilm = bundle.getInt(EXTRA_ID_FILM);
                presenter.loadFilm(idFilm);
            }
        }

        initTabLayout();
        initViewPager();

    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_film_info);
    }

    private void initPoster() {
        imagePoster = (ImageView) findViewById(R.id.image_poster_film_info);
    }

    private void initTabLayout() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_film_info);
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.view_pager_film_info);
        pagerAdapterFilmInfo = new ViewPagerAdapterFilmInfo(getSupportFragmentManager(), idFilm);
        viewPager.setAdapter(pagerAdapterFilmInfo);

        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void setFilmInfo(FilmDetail film) {
        Glide.with(this)
                .load(Api.getBackPoster(film.getBackdropPath()))
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imagePoster);
    }

    public static void newIntent(Context context, int idFilm) {
        Intent intent = new Intent(context, FilmInfoActivity.class);
        intent.putExtra(EXTRA_ID_FILM, idFilm);
        context.startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        
    }
}
