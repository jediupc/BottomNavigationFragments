package com.example.marcos.bottomnavigationfragments;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.marcos.bottomnavigationfragments.fragments.CalcFragment;
import com.example.marcos.bottomnavigationfragments.fragments.MemoryFragment;
import com.example.marcos.bottomnavigationfragments.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        //Load fragment for first time
        Fragment f = new ProfileFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,f)
                .commit();


        //Set listeners
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment f = null;
                        switch (item.getItemId()) {
                            case R.id.action_profile:
                                f = new ProfileFragment();
                                break;
                            case R.id.action_calc:
                                f = new CalcFragment();
                                break;
                            case R.id.action_memory:
                                f = new MemoryFragment();
                                break;
                        }
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container,f)
                                .commit();
                        return true;
                    }
                });


    }
}
