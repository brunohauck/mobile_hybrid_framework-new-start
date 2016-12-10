package com.mentorandroid.mobilehybridframework;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mentorandroid.mobilehybridframework.fragments.GenericFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public Fragment fragment;
    public FragmentTransaction ft;
    public String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        url = "http://www.softwareon.com.br/marmita";
        //this.setUrl(url);
        fragment = new GenericFragment();
        String title = "GENERIC FRAGMENT";

        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container_body, fragment);
        ft.addToBackStack(null);
        ft.commit();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
//            Fragment fragment = new GenericFragment();
//            String title = "GENERIC FRAGMENT";
//            if (fragment != null) {
//                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.container_body, fragment);
//                ft.addToBackStack(null);
//                ft.commit();
//
//                if (getSupportActionBar() != null) {
//                    getSupportActionBar().setTitle(title);
//                }
//            }
//            String url = "https://www.softwareon.com.br/marmita";
//            this.setUrl(url);
//            fragment.onResume();

            url = "http://www.softwareon.com.br/marmita";
//            if(fragment!=null) {
//                ft.remove(fragment).commit();
//            }
            fragment = new GenericFragment();
            String title = "GENERIC FRAGMENT";

            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container_body, fragment);
            ft.addToBackStack(null);
            ft.commit();

        } else if (id == R.id.nav_gallery) {
//
//            this.setUrl(url);
//            fragment.onResume();
//            String url = "file:///android_asset/teste.html";
//            if(fragment!=null) {
//                ft.remove(fragment).commit();
//            }
            url = "file:///android_asset/teste.html";
            fragment = new GenericFragment();
            String title = "GENERIC FRAGMENT";

            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container_body, fragment);
            ft.addToBackStack(null);
            ft.commit();
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(title);
            }

        } else if (id == R.id.nav_slideshow) {
            url = "http://sustentaculo.net/dev/";
            fragment = new GenericFragment();
            String title = "GENERIC FRAGMENT";
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container_body, fragment);
            ft.addToBackStack(null);
            ft.commit();
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(title);
            }

        } else if (id == R.id.nav_manage) {


        } else if (id == R.id.nav_share) {


        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
