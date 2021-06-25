package com.example.proj4;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DetailFragment detailFragment;
    ListFragment listFragment;
    DrawerLayout drawer;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("영화 목록");
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        listFragment = new ListFragment();
        detailFragment = new DetailFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.container, listFragment).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            drawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment curFragment = null;
        int id = item.getItemId();
        if(id == R.id.list){
            toolbar.setTitle("영화 목록");
            curFragment = ListFragment.newInstance();

        }
        else if(id == R.id.review){
            toolbar.setTitle("영화 상세");
            curFragment = DetailFragment.newInstance();
        }
        else if(id == R.id.book){
        }
        assert curFragment != null;
        getSupportFragmentManager().beginTransaction().replace(R.id.container, curFragment).commit();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onFragmentChanged(int index){
        Fragment curFragment;
        if(index == 0){
            detailFragment = new DetailFragment();
            toolbar.setTitle("영화 상세");
            curFragment = DetailFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, curFragment).commit();
        }
        else if(index == 1){
            toolbar.setTitle("영화 목록");
            curFragment = ListFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, curFragment).commit();
        }
    }

}
