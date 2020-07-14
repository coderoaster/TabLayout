package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter  extends FragmentPagerAdapter {

    int Tabnum;


    public PageAdapter(@NonNull FragmentManager fm , int Tabnum) {
        super(fm);
        this.Tabnum =Tabnum;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Fragment apple = new apple();
                return apple;
            case 1:
                Fragment grape = new grape();

                return grape;
            case 2:
                Fragment orange = new orange();
                return orange;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return Tabnum;
    }
}
