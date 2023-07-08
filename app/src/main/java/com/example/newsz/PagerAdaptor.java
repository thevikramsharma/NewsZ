package com.example.newsz;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabLayout;

public class PagerAdaptor extends FragmentPagerAdapter {
    int Tabcount;

    public PagerAdaptor( FragmentManager fm, int behavior) {
        super(fm, behavior);
        Tabcount=behavior;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new SportsFragment();
            case 2:
                return new HealthFragment();
            case 3:
                return new ScienceFragment();
            case 4:
                return new EntertainmentFragment();
            case 5:
                return new TechnologyFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return Tabcount;
    }
}
