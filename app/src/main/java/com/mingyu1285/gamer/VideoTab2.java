package com.mingyu1285.gamer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class VideoTab2 extends Fragment {


    DrawerLayout drawerLayout;
    TabLayout tabLayout;
    VideoTabAdapter adapter;
    ViewPager pager;

    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_tab2, container, false);

        drawerLayout= (DrawerLayout)view;
        Toolbar toolbar= view.findViewById(R.id.toolbar);
        ((FragmentActivity)getActivity()).setSupportActionBar(toolbar);

        ((FragmentActivity)getActivity()).getSupportActionBar().setTitle("유튜브 영상");

        adapter = new VideoTabAdapter(getChildFragmentManager());
        tabLayout = view.findViewById(R.id.layout_tab);
        pager = view.findViewById(R.id.pager);
        pager.setAdapter(adapter);

        tabLayout.setupWithViewPager(pager);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //((FragmentActivity) getActivity()).getSupportActionBar().setSubtitle(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

        navigationView = view.findViewById(R.id.nav);

        drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView = view.findViewById(R.id.nav);

        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                drawerLayout.closeDrawer(navigationView);
                return false;
            }
        });


        return  view;
    }
}
