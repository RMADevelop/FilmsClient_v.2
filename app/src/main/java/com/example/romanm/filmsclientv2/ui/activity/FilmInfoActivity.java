package com.example.romanm.filmsclientv2.ui.activity;

import android.content.Context;
import android.content.Intent;
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
import com.example.romanm.filmsclientv2.utils.Api;

public class FilmInfoActivity extends MvpAppCompatActivity implements FilmInfoView {

    private static final String EXTRA_ID_FILM = "EXTRA_ID_FILM";

    @InjectPresenter
    FilmInfoPresenterImpl presenter;

    private ImageView imagePoster;

    private Toolbar toolbar;

    private TabLayout tabLayout;

    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_info);

        initToolbar();
        initPoster();
        initTabLayout();

        initViewPager();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.getInt(EXTRA_ID_FILM) != -1) {
                presenter.loadFilm(bundle.getInt(EXTRA_ID_FILM));
            }
        }
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
}
