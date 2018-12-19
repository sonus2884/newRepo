package com.example.user.newapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.newapplication.Fragment.BrowserFragment;
import com.example.user.newapplication.Fragment.HomeFragment;
import com.example.user.newapplication.Fragment.ProfileFragment;
import com.example.user.newapplication.Fragment.RadioFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mNavigation;
    private android.support.v7.widget.Toolbar toolbar;
    private TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Home");

        titleText = findViewById(R.id.titleText);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mNavigation = findViewById(R.id.navigation);

        mNavigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener);

        loadFragment(new HomeFragment());
    }


    private BottomNavigationView.OnNavigationItemSelectedListener OnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment fragment;
                    switch (menuItem.getItemId()) {

                        case R.id.nav_home:
                            toolbar.setTitle("Home");
                            titleText.setText("Home");
                            fragment = new HomeFragment();
                            loadFragment(fragment);
                            return true;

                        case R.id.nav_Radio:
                            toolbar.setTitle("Radio");
                            titleText.setText("Radio");
                            fragment = new RadioFragment();
                            loadFragment(fragment);
                            return true;

                        case R.id.nav_browser:
                            toolbar.setTitle("Browser");
                            titleText.setText("Browser");
                            titleText.setTextSize(16f);
                            fragment = new BrowserFragment();
                            loadFragment(fragment);
                            return true;

                        case R.id.nav_profile:
                            toolbar.setTitle("Profile");
                            titleText.setText("Profile");
                            fragment = new ProfileFragment();
                            loadFragment(fragment);
                            return true;
                    }

                    return false;
                }
            };

    private void loadFragment(Fragment fragment) {
        // load the fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
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


  /*  @Override
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
    */


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment;

        if (id == R.id.nav_home) {
            // Handle the camera action

            toolbar.setTitle("Home");
            titleText.setText("Home");
            fragment = new HomeFragment();
            loadFragment(fragment);

        } else if (id == R.id.nav_people) {
            titleText.setText("people");
            fragment = new ProfileFragment();
            loadFragment(fragment);

        } else if (id == R.id.nav_Radio) {
            toolbar.setTitle("Radio");
            titleText.setText("Radio");
            fragment = new RadioFragment();
            loadFragment(fragment);

        } else if (id == R.id.nav_setting) {
            titleText.setText("Setting");
            titleText.setTextSize(16f);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void notification(View view) {


        Toast.makeText(MainActivity.this, "Notification", Toast.LENGTH_SHORT).show();
    }

    public void setting(View view) {

        Toast.makeText(MainActivity.this, "Setting", Toast.LENGTH_SHORT).show();
    }

    public void search(View view) {

        Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
    }

}
