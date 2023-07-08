package com.example.newsz;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem mhome, mhealth, mscience, mtechnology, mentertainment, msports;
    PagerAdaptor pagerAdaptor;
    Toolbar mtoolbar;
    String api="46d24548942a4ab181fc6d0765a42fef";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        mhome = findViewById(R.id.home);
        mscience = findViewById(R.id.Science);
        msports = findViewById(R.id.sports);
        mtechnology = findViewById(R.id.technology);
        mentertainment = findViewById(R.id.entertainment);
        mhealth = findViewById(R.id.health);
        ViewPager viewPager = findViewById(R.id.FragentContainer);
        tabLayout = findViewById(R.id.include);
        pagerAdaptor = new PagerAdaptor(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pagerAdaptor);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5) {
                    pagerAdaptor.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }
}
