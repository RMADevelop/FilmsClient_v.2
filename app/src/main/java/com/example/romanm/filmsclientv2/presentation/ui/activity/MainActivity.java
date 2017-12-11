package com.example.romanm.filmsclientv2.presentation.ui.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.romanm.filmsclientv2.R;
import com.example.romanm.filmsclientv2.presentation.ui.fragments.BaseInfoFragment;
import com.example.romanm.filmsclientv2.presentation.ui.fragments.FilmDetailFragment;
import com.example.romanm.filmsclientv2.presentation.ui.fragments.PremiersFragment;
import com.example.romanm.filmsclientv2.presentation.ui.fragments.SearchFragment;
import com.example.romanm.filmsclientv2.utils.ActivityUtils;

public class MainActivity extends MvpAppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, PremiersFragment.PremiersFragmentListener, SearchFragment.SearchFragmentListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActivityUtils.setFragment(getSupportFragmentManager(), PremiersFragment.getInstance(), R.id.container_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void startFilmInfo(int idFilm) {
        ActivityUtils.setFragmentWithBackStack(getSupportFragmentManager(), FilmDetailFragment.newInstance(idFilm), R.id.container_main);

    }

    @Override
    public void startSearch() {
        ActivityUtils.setFragmentWithBackStack(getSupportFragmentManager(), SearchFragment.newInstance(false), R.id.container_main);
    }

    @Override
    public void itemClick(int idFilm) {
        ActivityUtils.setFragmentWithBackStack(getSupportFragmentManager(), FilmDetailFragment.newInstance(idFilm), R.id.container_main);
    }
}
