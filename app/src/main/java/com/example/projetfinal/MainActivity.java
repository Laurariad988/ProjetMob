package com.example.projetfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.projetfinal.Menu.HomeFragment;
import com.example.projetfinal.Menu.ApiFragment;
import com.example.projetfinal.Menu.VideoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

    }
        private BottomNavigationView.OnNavigationItemSelectedListener navListener =

            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedfragment= null;


                    switch(item.getItemId()) {

                        case R.id.nav_home:
                            selectedfragment = new HomeFragment();
                            break;

                        case R.id.nav_favorites:
                            selectedfragment = new ApiFragment();
                            break;

                        case R.id.nav_search :
                            selectedfragment = new VideoFragment();
                            break;
                    }

                    final int commit = getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedfragment).commit();
                    return true;
                };

            };
};





