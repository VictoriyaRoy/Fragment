package com.example.user.fragment;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    Fragment1 frag1;
    Fragment2 frag2;
    Fragment3 frag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frag1 = new Fragment1();
        frag2 = new Fragment2();
        frag3 = new Fragment3();


        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.add:
                                addFragment(R.id.fragment_container,
                                        frag1,
                                        false,
                                        false);

                                break;
                            case R.id.create:
                                addFragment(R.id.fragment_container,
                                        frag2,
                                        false,
                                        false);

                                break;
                            case R.id.send:
                                addFragment(R.id.fragment_container,
                                        frag3,
                                        false,
                                        false);

                                break;
                        }
                        return true;
                    }
                });
    }

    @SuppressLint("CommitTransaction")
    protected void addFragment(Integer containerRes,
                               Fragment fragment,
                               boolean addToBackStack,
                               boolean animate) {
        FragmentTransaction transaction = this
                .getSupportFragmentManager().beginTransaction()
                .replace(containerRes, fragment,
                        fragment.getClass().getSimpleName());
        if (addToBackStack) {
            transaction = transaction.addToBackStack(
                    fragment.getClass().getSimpleName());
        }
        if (animate) {
            transaction = transaction.setTransition(
                    FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        }
        transaction.commitAllowingStateLoss();
    }


}
