package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ViewPager viewPager;
    PageAdapter adapter;
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.main_viewPager);



        tab = findViewById(R.id.main_tablayout);
        tab.addTab(tab.newTab().setText("사과"));
        tab.addTab(tab.newTab().setText("포도"));
        tab.addTab(tab.newTab().setText("오렌지"));
        tab.setTabGravity(tab.GRAVITY_FILL);

        tab.addOnTabSelectedListener( new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        viewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener(tab));
        adapter = new PageAdapter(getSupportFragmentManager(),3);
        viewPager.setAdapter(adapter);

    }




}